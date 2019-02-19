package com.taotao.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TbContent {
    private BigDecimal id;

    private BigDecimal categoryId;

    private Object title;

    private Object subTitle;

    private Object titleDesc;

    private Object url;

    private Object pic;

    private Object pic2;

    private Object content;

    private Date created;

    private Date updated;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(BigDecimal categoryId) {
        this.categoryId = categoryId;
    }

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

    public Object getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(Object subTitle) {
        this.subTitle = subTitle;
    }

    public Object getTitleDesc() {
        return titleDesc;
    }

    public void setTitleDesc(Object titleDesc) {
        this.titleDesc = titleDesc;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public Object getPic() {
        return pic;
    }

    public void setPic(Object pic) {
        this.pic = pic;
    }

    public Object getPic2() {
        return pic2;
    }

    public void setPic2(Object pic2) {
        this.pic2 = pic2;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
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