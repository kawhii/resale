package com.carl.resale.ui.bean;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 地区
 * @author Carl
 * @date 2016/3/29
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Document(collection = "sys_area")
public class SysArea {
    private ObjectId id;
    private String code;
    private String name;
    private int level;//地区级别
    private int order;
    private List<SysChildrenArea> children;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public List<SysChildrenArea> getChildren() {
        return children;
    }

    public void setChildren(List<SysChildrenArea> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "SysArea{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", order=" + order +
                ", children=" + children +
                '}';
    }
}
