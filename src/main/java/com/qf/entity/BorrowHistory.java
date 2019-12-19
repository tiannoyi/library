package com.qf.entity;

import java.util.Date;

public class BorrowHistory {
    private Integer historyId;

    private Integer readerId;

    private Date borrowTime;

    private Date repayTime;

    private Byte renew;

    private Byte overdue;

    private Float fine;

    private Integer bookId;

    private Integer isDelete;

    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
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

    public Float getFine() {
        return fine;
    }

    public void setFine(Float fine) {
        this.fine = fine;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}