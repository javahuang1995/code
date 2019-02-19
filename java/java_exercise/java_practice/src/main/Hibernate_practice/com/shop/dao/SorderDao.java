package com.shop.dao;

import java.util.List;

import com.shop.model.Forder;
import com.shop.model.Product;
import com.shop.model.Sorder;

public interface SorderDao extends BaseDao<Sorder> {
	//查询热点商品的销售量
	public List<Object> querySale(int number);
}
