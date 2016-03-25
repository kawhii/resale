package com.carl.resale.ui.bean;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Carl
 * @date 2016/3/19
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Document(collection="mall_categories")
public class Categories {
    @Field private ObjectId id;
    @Field private String name;
    @Field private String code;
    @Field private int order;
    @Field("css_name") private String cssName;//前端样式

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

    public String getCssName() {
        return cssName;
    }

    public void setCssName(String cssName) {
        this.cssName = cssName;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", order=" + order +
                ", cssName='" + cssName + '\'' +
                '}';
    }
}
