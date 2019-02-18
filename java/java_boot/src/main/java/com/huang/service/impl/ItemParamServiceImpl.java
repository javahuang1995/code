package com.huang.service.impl;

import java.util.Date;
import java.util.List;

import com.huang.common.pojo.EUDataGridResult;
import com.huang.common.pojo.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.huang.mapper.TbItemParamMapper;
import com.huang.pojo.TbItemParam;
import com.huang.pojo.TbItemParamExample;
import com.huang.pojo.TbItemParamExample.Criteria;
import com.huang.service.ItemParamService;

/**
 * 商品规格参数模板管理
 * <p>
 * Title: ItemParamServiceImpl
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 入云龙
 * @date 2015年9月5日下午2:36:57
 * @version 1.0
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private TbItemParamMapper itemParamMapper;

	@Override
	public TaotaoResult getItemParamByCid(long cid) {
		TbItemParamExample example = new TbItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
		// 判断是否查询到结果
		if (list != null && list.size() > 0) {
			return TaotaoResult.ok(list.get(0));
		}

		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult insertItemParam(TbItemParam itemParam) {
		// 补全pojo
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		// 插入到规格参数模板表
		itemParamMapper.insert(itemParam);
		return TaotaoResult.ok();
	}

	@Override
	public EUDataGridResult getItemParamList(int page, int rows) {
		// 查询商品列表
		TbItemParamExample example = new TbItemParamExample();
		// 分页处理
		PageHelper.startPage(page, rows);
		List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);//注意要用selectByExampleWithBLOBs
		
		// 创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		PageInfo<TbItemParam> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		
		return result;
	}

	@Override
	public TaotaoResult deleteItemParam(long ids) {
		itemParamMapper.deleteByPrimaryKey(ids);
		return TaotaoResult.ok();
	}

}
