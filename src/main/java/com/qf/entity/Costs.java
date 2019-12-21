package com.qf.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Costs {
    private Integer costId;

    private Integer readerId;

    private Byte costType;

    private Float numeric;

    private Byte payType;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Integer isDelete;

    public Costs() {
    }

    public Costs(Integer readerId, Byte costType, Float numeric, Byte payType) {
        this.readerId = readerId;
        this.costType = costType;
        this.numeric = numeric;
        this.payType = payType;
    }

    public Costs(Integer readerId, Byte costType, Float numeric, Byte payType, Date createTime) {
        this.readerId = readerId;
        this.costType = costType;
        this.numeric = numeric;
        this.payType = payType;
        this.createTime = createTime;
    }

    public Costs(Integer readerId, Byte costType, Float numeric) {
        this.readerId = readerId;
        this.costType = costType;
        this.numeric = numeric;
    }

    public Costs(Integer readerId, Byte costType) {
        this.readerId = readerId;
        this.costType = costType;
    }

    public Costs(Integer readerId) {
        this.readerId = readerId;
    }

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public Byte getCostType() {
        return costType;
    }

    public void setCostType(Byte costType) {
        this.costType = costType;
    }

    public Float getNumeric() {
        return numeric;
    }

    public void setNumeric(Float numeric) {
        this.numeric = numeric;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}