package com.carl.resale.ui.bean;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * 文件
 * @author Carl
 * @date 2016/3/28
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Document(collection = "sys_file")
public class SysFile {
    @Field
    private ObjectId id;
    @Field("business") private String business;
    @Field("type") private String type;
    @Field("size")private Long size;
    @Field private String name;
    @Field private Date createTime;
    @Field private String note;
    @Field("busi_type") private String busiType;//路径为类型+名字
    @Field("status") private int status;
    @Field("path") private String path;//路径
    @Field("creatorId") private ObjectId creatorId;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ObjectId getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(ObjectId creatorId) {
        this.creatorId = creatorId;
    }

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }

    @Override
    public String toString() {
        return "SysFile{" +
                "id=" + id +
                ", business='" + business + '\'' +
                ", busi_type='" + busiType + '\'' +
                ", type='" + type + '\'' +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", note='" + note + '\'' +
                ", status=" + status +
                ", path='" + path + '\'' +
                ", creatorId=" + creatorId +
                '}';
    }
}
