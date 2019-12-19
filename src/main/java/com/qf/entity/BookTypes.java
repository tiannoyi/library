package com.qf.entity;

public class BookTypes {
    private Integer bookTypeId;

    private String bookTypeName;

    private String fatherNode;

    private String classNumber;

    private Integer isDelete;

    public Integer getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(Integer bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public String getBookTypeName() {
        return bookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName == null ? null : bookTypeName.trim();
    }

    public String getFatherNode() {
        return fatherNode;
    }

    public void setFatherNode(String fatherNode) {
        this.fatherNode = fatherNode == null ? null : fatherNode.trim();
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber == null ? null : classNumber.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}