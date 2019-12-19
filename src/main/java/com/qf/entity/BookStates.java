package com.qf.entity;

public class BookStates {
    private Integer bookStateId;

    private Integer bookId;

    private String barCode;

    private Byte state;

    private Short borrowNumber;

    private Integer isDelete;

    public Integer getBookStateId() {
        return bookStateId;
    }

    public void setBookStateId(Integer bookStateId) {
        this.bookStateId = bookStateId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode == null ? null : barCode.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Short getBorrowNumber() {
        return borrowNumber;
    }

    public void setBorrowNumber(Short borrowNumber) {
        this.borrowNumber = borrowNumber;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}