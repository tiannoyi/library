package com.qf.util;

import java.util.List;

public class Page<T> {
    // 当前页
    private Integer currentPage = 1;
    // 每页显示的总条数
    private Integer pageSize = 10;
    // 总条数
    private Integer totalNum = 0;
    // 是否有下一页
    private Integer isMore;
    // 总页数
    private Integer totalPage;
    // 开始索引
    private Integer startIndex;
    // 分页结果
    private List<T> List;
    //请求连接路径
    private String  url;

    public Page() {
        super();
    }

    public Page(Integer currentPage, Integer pageSize, Integer totalNum) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.totalPage = (this.totalNum+this.pageSize-1)/this.pageSize;
        this.startIndex = (this.currentPage-1)*this.pageSize;
        this.isMore = this.currentPage >= this.totalPage?0:1;
    }

    public Page(Integer currentPage, Integer pageSize, Integer totalNum, String url) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.totalPage = (this.totalNum+this.pageSize-1)/this.pageSize;
        this.startIndex = (this.currentPage-1)*this.pageSize;
        this.isMore = this.currentPage >= this.totalPage?0:1;
        this.url = url;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
        if (this.pageSize > 0){
            this.startIndex = (this.currentPage-1)*this.pageSize;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        if (this.totalNum > 0){
            this.totalPage = (this.totalNum+this.pageSize-1)/this.pageSize;
        }
        if (this.currentPage > 0){
            this.startIndex = (this.currentPage-1)*this.pageSize;
        }
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
        if (this.pageSize > 0){
            this.totalPage = (this.totalNum+this.pageSize-1)/this.pageSize;
        }
    }

    public Integer getIsMore() {
        return isMore;
    }

    public void setIsMore(Integer isMore) {
        this.isMore = isMore;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

   /* public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }*/

    public Integer getStartIndex() {
        return startIndex;
    }

    /*public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }*/

    public java.util.List<T> getList() {
        return List;
    }

    public void setList(java.util.List<T> list) {
        List = list;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
