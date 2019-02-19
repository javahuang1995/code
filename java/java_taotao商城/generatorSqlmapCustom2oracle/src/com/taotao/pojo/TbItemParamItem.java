package com.taotao.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TbItemParamItem {
    private BigDecimal id;

    private BigDecimal itemId;

    private Object paramData;

    private Date created;

    private Date updated;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getItemId() {
        return itemId;
    }

    public void setItemId(BigDecimal itemId) {
        this.itemId = itemId;
    }

    public Object getParamData() {
        return paramData;
    }

    public void setParamData(Object paramData) {
        this.paramData = paramData;
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