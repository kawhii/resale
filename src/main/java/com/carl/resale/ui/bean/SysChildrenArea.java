package com.carl.resale.ui.bean;

import org.bson.types.ObjectId;

/**
 * 子地区
 * @author Carl
 * @date 2016/3/29
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class SysChildrenArea {
    private ObjectId id;//是SysArea.id的引用
    private String name;
    private String code;
    private int order;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
