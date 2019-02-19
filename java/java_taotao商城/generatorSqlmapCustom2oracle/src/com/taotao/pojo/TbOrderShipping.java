package com.taotao.pojo;

import java.util.Date;

public class TbOrderShipping {
    private Object orderId;

    private Object receiverName;

    private Object receiverPhone;

    private Object receiverMobile;

    private Object receiverState;

    private Object receiverCity;

    private Object receiverDistrict;

    private Object receiverAddress;

    private Object receiverZip;

    private Date created;

    private Date updated;

    public Object getOrderId() {
        return orderId;
    }

    public void setOrderId(Object orderId) {
        this.orderId = orderId;
    }

    public Object getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(Object receiverName) {
        this.receiverName = receiverName;
    }

    public Object getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(Object receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public Object getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(Object receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public Object getReceiverState() {
        return receiverState;
    }

    public void setReceiverState(Object receiverState) {
        this.receiverState = receiverState;
    }

    public Object getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(Object receiverCity) {
        this.receiverCity = receiverCity;
    }

    public Object getReceiverDistrict() {
        return receiverDistrict;
    }

    public void setReceiverDistrict(Object receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    public Object getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(Object receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public Object getReceiverZip() {
        return receiverZip;
    }

    public void setReceiverZip(Object receiverZip) {
        this.receiverZip = receiverZip;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}