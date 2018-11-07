package com.qz.zframe.common.util;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class PageBean<T> {
    // 当前页
    @ApiModelProperty(value="当前页",name="currentPage",required=false)
    private Integer currentPage = 1;
    // 每页显示的总条数
    @ApiModelProperty(value="每页显示的总条数",name="pageSize",required=false)
    private Integer pageSize = 10;
    // 总条数
    @ApiModelProperty(value="总条数",name="totalNum",required=false)
    private Integer totalNum;
    // 是否有下一页
    @ApiModelProperty(value="是否有下一页(0,没有；1，有)",name="isMore",required=false)
    private Integer isMore;
    // 总页数
    @ApiModelProperty(value="总页数",name="totalPage",required=false)
    private Integer totalPage;
    // 开始索引
    @ApiModelProperty(value="开始索引,0即表示第一页",name="startIndex",required=false)
    private Integer startIndex;
    // 分页结果
    private List<T> items;

    public PageBean() {
        super();
    }

    public PageBean(Integer currentPage, Integer pageSize, Integer totalNum) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.totalPage = (this.totalNum+this.pageSize-1)/this.pageSize;
        this.startIndex = (this.currentPage-1)*this.pageSize;
        this.isMore = this.currentPage >= this.totalPage?0:1;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
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

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}

