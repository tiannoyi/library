package com.qf.entity;

public class System {
    private Integer sysId;

    private String sysName;

    private String sysImg;

    private String pageLine;

    private Integer appid;

    private String appsecret;

    private String barName;

    private Float fine;

    private Integer isDelete;

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName == null ? null : sysName.trim();
    }

    public String getSysImg() {
        return sysImg;
    }

    public void setSysImg(String sysImg) {
        this.sysImg = sysImg == null ? null : sysImg.trim();
    }

    public String getPageLine() {
        return pageLine;
    }

    public void setPageLine(String pageLine) {
        this.pageLine = pageLine == null ? null : pageLine.trim();
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret == null ? null : appsecret.trim();
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName == null ? null : barName.trim();
    }

    public Float getFine() {
        return fine;
    }

    public void setFine(Float fine) {
        this.fine = fine;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}