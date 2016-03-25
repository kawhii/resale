package com.carl.resale.ui.bean;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Carl
 * @date 2016/3/23
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Document(collection="mall_specific_type")
public class SpecificType {
    @Field
    private ObjectId id;

    @Field private String code;

    @Field("goods_count") private int goodsCount;
    @Field("order") private int order;

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

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "SpecificType{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", goodsCount=" + goodsCount +
                ", order=" + order +
                '}';
    }
}
