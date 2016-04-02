package com.carl.resale.ui.bean;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 热门推荐广告
 * @author Carl
 * @date 2016/4/2
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Document(collection = "mall_hot_advantage")
public class HotAdvantage {
    private ObjectId id;

    @DBRef
    private Advantage advantage;

    private State state;

    private int order;

    public Advantage getAdvantage() {
        return advantage;
    }

    public void setAdvantage(Advantage advantage) {
        this.advantage = advantage;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "HotAdvantage{" +
                "advantage=" + advantage +
                "id=" + id +
                ", state=" + state +
                ", order=" + order +
                '}';
    }
}
