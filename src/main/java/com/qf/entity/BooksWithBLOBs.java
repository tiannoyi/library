package com.qf.entity;

public class BooksWithBLOBs extends Books {
    private String introduction;

    private String directory;

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory == null ? null : directory.trim();
    }
}