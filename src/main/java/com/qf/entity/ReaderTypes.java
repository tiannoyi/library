package com.qf.entity;

public class ReaderTypes {
    private Integer readerTypeId;

    private String readerTypeName;

    private Byte borrowDay;

    private Byte borrowNumber;

    private Byte continueNumber;

    private Float deposit;

    private Integer isDelete;


    public ReaderTypes() {
    }

    /**
     * 无 readerTypeId,isDelete 构造
     *
     * @param readerTypeName
     * @param borrowDay
     * @param borrowNumber
     * @param continueNumber
     * @param deposit
     */
    public ReaderTypes(String readerTypeName, Byte borrowDay, Byte borrowNumber, Byte continueNumber, Float deposit) {
        this.readerTypeName = readerTypeName;
        this.borrowDay = borrowDay;
        this.borrowNumber = borrowNumber;
        this.continueNumber = continueNumber;
        this.deposit = deposit;
    }

    /**
     * 全参构造
     *
     * @param readerTypeId
     * @param readerTypeName
     * @param borrowDay
     * @param borrowNumber
     * @param continueNumber
     * @param deposit
     * @param isDelete
     */
    public ReaderTypes(Integer readerTypeId, String readerTypeName, Byte borrowDay, Byte borrowNumber, Byte continueNumber, Float deposit, Integer isDelete) {
        this.readerTypeId = readerTypeId;
        this.readerTypeName = readerTypeName;
        this.borrowDay = borrowDay;
        this.borrowNumber = borrowNumber;
        this.continueNumber = continueNumber;
        this.deposit = deposit;
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "ReaderTypes{" +
                "readerTypeId=" + readerTypeId +
                ", readerTypeName='" + readerTypeName + '\'' +
                ", borrowDay=" + borrowDay +
                ", borrowNumber=" + borrowNumber +
                ", continueNumber=" + continueNumber +
                ", deposit=" + deposit +
                ", isDelete=" + isDelete +
                '}';
    }

    public Integer getReaderTypeId() {
        return readerTypeId;
    }

    public void setReaderTypeId(Integer readerTypeId) {
        this.readerTypeId = readerTypeId;
    }

    public String getReaderTypeName() {
        return readerTypeName;
    }

    public void setReaderTypeName(String readerTypeName) {
        this.readerTypeName = readerTypeName == null ? null : readerTypeName.trim();
    }

    public Byte getBorrowDay() {
        return borrowDay;
    }

    public void setBorrowDay(Byte borrowDay) {
        this.borrowDay = borrowDay;
    }

    public Byte getBorrowNumber() {
        return borrowNumber;
    }

    public void setBorrowNumber(Byte borrowNumber) {
        this.borrowNumber = borrowNumber;
    }

    public Byte getContinueNumber() {
        return continueNumber;
    }

    public void setContinueNumber(Byte continueNumber) {
        this.continueNumber = continueNumber;
    }

    public Float getDeposit() {
        return deposit;
    }

    public void setDeposit(Float deposit) {
        this.deposit = deposit;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}