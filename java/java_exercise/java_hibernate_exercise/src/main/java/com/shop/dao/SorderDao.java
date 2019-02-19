package com.shop.dao;

import com.shop.model.Sorder;

import java.util.List;

public interface SorderDao extends BaseDao<Sorder> {
	//查询热点商品的销售量
	public List<Object> querySale(int number);
}
