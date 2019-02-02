package com.shop.dao;

import java.math.BigDecimal;

import com.shop.model.Forder;

public interface ForderDao extends BaseDao<Forder> {
	//根据订单编号，更新订单状态
	public void updateStatusById(int id, int sid);
}
