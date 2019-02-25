package com.taotao.pojo;

import java.io.Serializable;
import java.util.List;

public class Order extends TbOrder implements Serializable
{
	private static final long serialVersionUID=1L;

	private List<TbOrderItem> orderItems;//是一个List，包括买的商品列表
	private TbOrderShipping orderShipping;//这是物流信息，记录购买人的收件地址。
	public List<TbOrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<TbOrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public TbOrderShipping getOrderShipping() {
		return orderShipping;
	}
	public void setOrderShipping(TbOrderShipping orderShipping) {
		this.orderShipping = orderShipping;
	}
	
	
}
