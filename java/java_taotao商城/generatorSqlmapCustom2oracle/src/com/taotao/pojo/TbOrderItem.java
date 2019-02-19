package com.taotao.pojo;

import java.math.BigDecimal;

public class TbOrderItem {
    private Object id;

    private Object itemId;

    private Object orderId;

    private Long num;

    private Object title;

    private BigDecimal price;

    private BigDecimal totalFee;

    private Object picPath;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getItemId() {
        return itemId;
    }

    public void setItemId(Object itemId) {
        this.itemId = itemId;
    }

    public Object getOrderId() {
        return orderId;
    }

    public void setOrderId(Object orderId) {
        this.orderId = orderId;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public Object getPicPath() {
        return picPath;
    }

    public void setPicPath(Object picPath) {
        this.picPath = picPath;
    }
}