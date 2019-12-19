package com.qf.entity;

import java.util.Date;

public class Logs {
    private Integer id;

    private Date time;

    private Integer adminId;

    private String opeAction;

    private String opeEntity;

    private String opeDetail;

    private Integer isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getOpeAction() {
        return opeAction;
    }

    public void setOpeAction(String opeAction) {
        this.opeAction = opeAction == null ? null : opeAction.trim();
    }

    public String getOpeEntity() {
        return opeEntity;
    }

    public void setOpeEntity(String opeEntity) {
        this.opeEntity = opeEntity == null ? null : opeEntity.trim();
    }

    public String getOpeDetail() {
        return opeDetail;
    }

    public void setOpeDetail(String opeDetail) {
        this.opeDetail = opeDetail == null ? null : opeDetail.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}