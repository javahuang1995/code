package com.taotao.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TbOrder {
    private Object orderId;

    private Object payment;

    private Long paymentType;

    private Object postFee;

    private Long status;

    private Date createTime;

    private Date updateTime;

    private Date paymentTime;

    private Date consignTime;

    private Date endTime;

    private Date closeTime;

    private Object shippingName;

    private Object shippingCode;

    private BigDecimal userId;

    private Object buyerMessage;

    private Object buyerNick;

    private Long buyerRate;

    public Object getOrderId() {
        return orderId;
    }

    public void setOrderId(Object orderId) {
        this.orderId = orderId;
    }

    public Object getPayment() {
        return payment;
    }

    public void setPayment(Object payment) {
        this.payment = payment;
    }

    public Long getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Long paymentType) {
        this.paymentType = paymentType;
    }

    public Object getPostFee() {
        return postFee;
    }

    public void setPostFee(Object postFee) {
        this.postFee = postFee;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(Date consignTime) {
        this.consignTime = consignTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Object getShippingName() {
        return shippingName;
    }

    public void setShippingName(Object shippingName) {
        this.shippingName = shippingName;
    }

    public Object getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(Object shippingCode) {
        this.shippingCode = shippingCode;
    }

    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    public Object getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(Object buyerMessage) {
        this.buyerMessage = buyerMessage;
    }

    public Object getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(Object buyerNick) {
        this.buyerNick = buyerNick;
    }

    public Long getBuyerRate() {
        return buyerRate;
    }

    public void setBuyerRate(Long buyerRate) {
        this.buyerRate = buyerRate;
    }
}