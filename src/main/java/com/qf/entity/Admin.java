package com.qf.entity;

public class Admin {
    private Integer adminId;

    private String adminName;

    private String phone;

    private String password;

    private String salt;

    private Integer roleId;

    private Integer isDelete;


    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Admin(Integer adminId, String adminName, String phone, String password, String salt, Integer roleId, Integer isDelete) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.phone = phone;
        this.password = password;
        this.salt = salt;
        this.roleId = roleId;
        this.isDelete = isDelete;
    }

    public Admin() {
    }

    public Admin(Integer adminId, String password) {
        this.adminId = adminId;
        this.password = password;
    }
}