package com.carl.resale.ui.bean;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * 目录
 * @author Carl
 * @date 2016/3/23
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Document(collection="mall_category")
public class Category {
    @Field
    private ObjectId id;
    @Field private String name;
    @Field private String code;
    @Field private int order;
    @Field("css_name") private String cssName;//前端样式
    @Field("state") private State state;
    @Field("goods_count") private int goodsCount;//广告总数
    @Field("image_id")private ObjectId imageId;
    @Field("image_type")private String imageType;
    @DBRef
    @Field("spec_types") private List<SpecificType> specTypes;
    @Field("business_id") private String business;

    @Field("show_types")
    private List<ShowType> showTypes;

    public List<ShowType> getShowTypes() {
        return showTypes;
    }

    public void setShowTypes(List<ShowType> showTypes) {
        this.showTypes = showTypes;
    }

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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public ObjectId getImageId() {
        return imageId;
    }

    public void setImageId(ObjectId imageId) {
        this.imageId = imageId;
    }

    public List<SpecificType> getSpecTypes() {
        return specTypes;
    }

    public void setSpecTypes(List<SpecificType> specTypes) {
        this.specTypes = specTypes;
    }

    public String getBusiness() {
        return business;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", imageType='" + imageType + '\'' +
                ", order=" + order +
                ", cssName='" + cssName + '\'' +
                ", state=" + state +
                ", goodsCount=" + goodsCount +
                ", imageId=" + imageId +
                ", specTypes=" + specTypes +
                ", business='" + business + '\'' +
                ", showTypes='" + showTypes + '\'' +
                '}';
    }

    /**
     * 拥有哪些tab标签展示类型
     */
    public static class ShowType {
        private ObjectId id;
        private String title;
        private int order;

        public ObjectId getId() {
            return id;
        }

        public void setId(ObjectId id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }
    }
}
