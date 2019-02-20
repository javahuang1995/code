package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.huang.common.pojo.EUTreeNode;
import com.huang.common.pojo.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;
import com.taotao.service.ContentCategoryService;

/**
 * 内容分类管理
 * <p>
 * Title: ContentCategoryServiceImpl
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 入云龙
 * @date 2015年9月8日上午9:17:41
 * @version 1.0
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;

	@Override
	public List<EUTreeNode> getCategoryList(long parentId) {
		// 根据parentid查询节点列表
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		// 执行查询
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		List<EUTreeNode> resultList = new ArrayList<>();
		for (TbContentCategory tbContentCategory : list) {
			// 创建一个节点
			EUTreeNode node = new EUTreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent() ? "closed" : "open");

			resultList.add(node);
		}
		return resultList;
	}

	@Override
	public TaotaoResult insertContentCategory(long parentId, String name) {

		// 创建一个pojo
		TbContentCategory contentCategory = new TbContentCategory();
		contentCategory.setName(name);
		contentCategory.setIsParent(false);
		// '状态。可选值:1(正常),2(删除)',
		contentCategory.setStatus(1);
		contentCategory.setParentId(parentId);
		contentCategory.setSortOrder(1);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		// 添加记录
		contentCategoryMapper.insert(contentCategory);
		// 查看父节点的isParent列是否为true，如果不是true改成true
		TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);
		// 判断是否为true
		if (!parentCat.getIsParent()) {
			parentCat.setIsParent(true);
			// 更新父节点
			contentCategoryMapper.updateByPrimaryKey(parentCat);
		}
		// 返回结果
		return TaotaoResult.ok(contentCategory);
	}

	@Override
	public TaotaoResult updateContentCategory(long id, String name) {
		// 创建一个pojo
		TbContentCategory contentCategory =contentCategoryMapper.selectByPrimaryKey(id);
		contentCategory.setName(name);
		contentCategoryMapper.updateByPrimaryKey(contentCategory);
		return TaotaoResult.ok(contentCategory);
	}

	/**
	 * 业务逻辑：
	 * 如果没有子节点。需要把parentid对应的记录的isparent改成false。
	 */
	@Override
	public TaotaoResult deleteContentCategory(long id) {
		
		TbContentCategory tbContent = contentCategoryMapper.selectByPrimaryKey(id);
		long parentId = 0;
		if(tbContent != null){///判空指针，，哎，好麻烦。。。各种判断空指针
			parentId = tbContent.getParentId();
		}
		
		contentCategoryMapper.deleteByPrimaryKey(id);//删除掉
		
		//查看父亲节点还有没有子节点
		TbContentCategoryExample example = new TbContentCategoryExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		List<TbContentCategory> result = contentCategoryMapper.selectByExample(example);
		
		if(CollectionUtils.isEmpty(result)){//如果父亲节点再没有子节点的话，就更新父节点的IsParent属性。
			tbContent = contentCategoryMapper.selectByPrimaryKey(parentId);//找出父节点是parentId的节点
			tbContent.setIsParent(false);
			contentCategoryMapper.updateByPrimaryKey(tbContent);
		}

		
		return TaotaoResult.ok();
	}

}
