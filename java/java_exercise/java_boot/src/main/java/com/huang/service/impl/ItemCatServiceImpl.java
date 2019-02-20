package com.huang.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.huang.common.pojo.EUTreeNode;
import com.huang.common.pojo.TaotaoResult;
import com.huang.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.huang.mapper.TbItemCatMapper;
import com.huang.pojo.TbItemCat;
import com.huang.pojo.TbItemCatExample;
import com.huang.pojo.TbItemCatExample.Criteria;

/**
 * 商品分类管理
 * <p>
 * Title: ItemCatServiceImpl
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 入云龙
 * @date 2015年9月4日上午9:16:50
 * @version 1.0
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public List<EUTreeNode> getCatList(long parentId) {

		// 创建查询条件
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		// 根据条件查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		List<EUTreeNode> resultList = new ArrayList<>();
		// 把列表转换成treeNodelist
		for (TbItemCat tbItemCat : list) {
			EUTreeNode node = new EUTreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent() ? "closed" : "open");
			resultList.add(node);
		}
		// 返回结果
		return resultList;
	}

	@Override
	public TaotaoResult addItemCat(long parentId, String name) {
		TbItemCat tbItemCat = new TbItemCat();
		tbItemCat.setName(name);
		tbItemCat.setParentId(parentId);
		tbItemCat.setStatus(1);
		tbItemCat.setIsParent(false);
		tbItemCat.setSortOrder(1);

		tbItemCat.setCreated(new Date());
		tbItemCat.setUpdated(new Date());

		// 查看父节点的isParent列是否为true，如果不是true改成true
		TbItemCat parentCat = itemCatMapper.selectByPrimaryKey(parentId);
		// 判断是否为true
		if (!parentCat.getIsParent()) {
			parentCat.setIsParent(true);
			// 更新父节点
			itemCatMapper.updateByPrimaryKey(parentCat);
		}

		itemCatMapper.insert(tbItemCat);
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult deleteItemCat(long id) {
		TbItemCat tbItemCat = itemCatMapper.selectByPrimaryKey(id);
		long parentId = 0;
		if (tbItemCat != null) {
			parentId = tbItemCat.getParentId();
		}
		
		itemCatMapper.deleteByPrimaryKey(id);//删掉

		// 查看父亲节点还有没有子节点
		TbItemCatExample example = new TbItemCatExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		List<TbItemCat> result = itemCatMapper.selectByExample(example);

		if (result == null || result.size() == 0) {// 如果父亲节点再没有子节点的话，就更新父节点的IsParent属性。
		    tbItemCat= itemCatMapper.selectByPrimaryKey(parentId);// 找出父节点是parentId的节点
		    tbItemCat.setIsParent(false);
		    itemCatMapper.updateByPrimaryKey(tbItemCat);
		}

		return TaotaoResult.ok();
	}
	
	@Override
	public TaotaoResult updateIetmCat(long id, String name) {
		// 创建一个pojo
		TbItemCat itemCat = itemCatMapper.selectByPrimaryKey(id);
		itemCat.setName(name);
		itemCatMapper.updateByPrimaryKey(itemCat);
		return TaotaoResult.ok(itemCat);
	}

}
