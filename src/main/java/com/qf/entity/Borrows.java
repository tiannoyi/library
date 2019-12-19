package com.qf.entity;

import java.util.Date;

public class Borrows {
    private Integer borrowId;

    private Date borrowTime;

    private Date repayTime;

    private Byte renew;

    private Byte overdue;

    private Integer readerId;

    private Integer bookStateId;

    private Float fine;

    private Integer isDelete;

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Date getRepayTime() {
        return repayTime;
    }

    public void setRepayTime(Date repayTime) {
        this.repayTime = repayTime;
    }

    public Byte getRenew() {
        return renew;
    }

    public void setRenew(Byte renew) {
        this.renew = renew;
    }

    public Byte getOverdue() {
        return overdue;
    }

    public void setOverdue(Byte overdue) {
        this.overdue = overdue;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public Integer getBookStateId() {
        return bookStateId;
    }

    public void setBookStateId(Integer bookStateId) {
        this.bookStateId = bookStateId;
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