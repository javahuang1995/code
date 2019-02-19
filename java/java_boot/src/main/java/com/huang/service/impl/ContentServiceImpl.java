package com.huang.service.impl;

import java.util.Date;
import java.util.List;

import com.huang.common.pojo.EUDataGridResult;
import com.huang.common.pojo.TaotaoResult;
import com.huang.common.utils.HttpClientUtil;
import com.huang.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.huang.mapper.TbContentMapper;
import com.huang.pojo.TbContent;
import com.huang.pojo.TbContentExample;
import com.huang.pojo.TbContentExample.Criteria;

/**
 * 内容管理
 * <p>
 * Title: ContentServiceImpl
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 入云龙
 * @date 2015年9月8日上午11:09:53
 * @version 1.0
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;

	public String getREST_BASE_URL() {
		return REST_BASE_URL;
	}
	@Value("${REST_SYNC_URL}")
	public void setREST_BASE_URL(String REST_BASE_URL) {
		this.REST_BASE_URL = REST_BASE_URL;
	}


	private String REST_BASE_URL;

	public String getREST_SYNC_URL() {
		return REST_SYNC_URL;
	}
	@Value("${REST_BASE_URL}")
	public void setREST_SYNC_URL(String REST_SYNC_URL) {
		this.REST_SYNC_URL = REST_SYNC_URL;
	}


	private String REST_SYNC_URL;

	/**
	 * 这是自己写的，不知道对不对
	 */
	@Override
	public TbContent getItemById(long itemId) {

		// 添加查询条件
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbContent> list = contentMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			TbContent item = list.get(0);
			return item;
		}
		return null;
	}

	@Override
	public TaotaoResult insertContent(TbContent content) {
		// 补全pojo内容
		content.setCreated(new Date());
		content.setUpdated(new Date());
		contentMapper.insert(content);

		// 添加缓存同步逻辑
		try {
			HttpClientUtil.doGet(REST_BASE_URL + REST_SYNC_URL);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return TaotaoResult.ok();
	}

	@Override
	public EUDataGridResult getItemList(Long categoryId, int page, int rows) {
		// 查询商品列表
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		// 分页处理
		PageHelper.startPage(page, rows);
		List<TbContent> list = contentMapper.selectByExample(example);
		// 创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		// 取记录总条数
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public TaotaoResult deleteContent(Long ids) {
		contentMapper.deleteByPrimaryKey(ids);
		return TaotaoResult.ok();
	}

}