package com.taotao.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TbItemDesc {
    private BigDecimal itemId;

    private Object itemDesc;

    private Date created;

    private Date updated;

    public BigDecimal getItemId() {
        return itemId;
    }

    public void setItemId(BigDecimal itemId) {
        this.itemId = itemId;
    }

    public Object getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(Object itemDesc) {
        this.itemDesc = itemDesc;
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