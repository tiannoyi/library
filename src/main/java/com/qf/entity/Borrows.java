package com.qf.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Borrows {
    private Integer borrowId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date borrowTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date repayTime;

    private Byte renew;

    private Byte overdue;

    private Integer readerId;

    private Integer bookStateId;

    private Float fine;

    private Integer isDelete;

    @Override
    public String toString() {
        return "Borrows{" +
                "borrowId=" + borrowId +
                ", borrowTime=" + borrowTime +
                ", repayTime=" + repayTime +
                ", renew=" + renew +
                ", overdue=" + overdue +
                ", readerId=" + readerId +
                ", bookStateId=" + bookStateId +
                ", fine=" + fine +
                ", isDelete=" + isDelete +
                '}';
    }

    public Borrows() {
    }

    /**
     * 无 borrowId 、 isDelete 参数构造
     *
     * @param borrowTime
     * @param repayTime
     * @param renew
     * @param overdue
     * @param readerId
     * @param bookStateId
     * @param fine
     */
    public Borrows(Date borrowTime, Date repayTime, Byte renew, Byte overdue, Integer readerId, Integer bookStateId, Float fine) {
        this.borrowTime = borrowTime;
        this.repayTime = repayTime;
        this.renew = renew;
        this.overdue = overdue;
        this.readerId = readerId;
        this.bookStateId = bookStateId;
        this.fine = fine;
    }

    /**
     * 无 borrowId, isDelete, Time 类构造
     * @param renew
     * @param overdue
     * @param readerId
     * @param bookStateId
     * @param fine
     */
    public Borrows(Byte renew, Byte overdue, Integer readerId, Integer bookStateId, Float fine) {
        this.renew = renew;
        this.overdue = overdue;
        this.readerId = readerId;
        this.bookStateId = bookStateId;
        this.fine = fine;
    }

    /**
     * 全参构造
     *
     * @param borrowId
     * @param borrowTime
     * @param repayTime
     * @param renew
     * @param overdue
     * @param readerId
     * @param bookStateId
     * @param fine
     * @param isDelete
     */
    public Borrows(Integer borrowId, Date borrowTime, Date repayTime, Byte renew, Byte overdue, Integer readerId, Integer bookStateId, Float fine, Integer isDelete) {
        this.borrowId = borrowId;
        this.borrowTime = borrowTime;
        this.repayTime = repayTime;
        this.renew = renew;
        this.overdue = overdue;
        this.readerId = readerId;
        this.bookStateId = bookStateId;
        this.fine = fine;
        this.isDelete = isDelete;
    }

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