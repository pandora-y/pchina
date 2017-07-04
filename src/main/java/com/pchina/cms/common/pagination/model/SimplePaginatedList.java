package com.pchina.cms.common.pagination.model;

import java.util.List;

public class SimplePaginatedList<T> implements PaginationList<T> {

    private static final long serialVersionUID = 1L;

    private int pageNo = 1;

    private int pageSize = DEFAULT_PAGE_SIZE;

    private int totalSize = 0;

    private List<T> pageRecords = null;

    private List<T> totalRecords = null;

    private int pageCount;

    private void adjustPage() {
        if(this.totalRecords != null) {
            this.totalSize = this.totalRecords.size();
        }
        if(this.totalSize < 0) {
            this.totalSize = 0;
            this.pageRecords = null;
        }
        this.pageSize = pageSize > 0?pageSize:DEFAULT_PAGE_SIZE;
        this.pageCount = (this.totalSize - 1) / this.pageSize + 1;
        if(this.pageNo > this.pageCount) this.pageNo = this.pageCount;
        if(this.pageNo <= 0) this.pageNo = 1;

        if(this.totalRecords != null && this.totalSize > 0) {
            int fromIndex = (this.pageNo - 1) * this.pageSize;
            int toIndex = fromIndex + this.pageSize;
            if(toIndex > this.totalRecords.size()) {
                toIndex = this.totalRecords.size();
            }
            this.pageRecords = this.totalRecords.subList(fromIndex, toIndex);
        }
    }

    public SimplePaginatedList(List<T> pageRecords, int pageNo, int pageSize, int totalSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageRecords = pageRecords;
        this.totalSize = totalSize;

        adjustPage();
    }

    public SimplePaginatedList(List<T> totalRecords, int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalRecords = totalRecords;

        adjustPage();
    }

    public SimplePaginatedList(List<T> totalRecords, int pageNo) {
        this.pageNo = pageNo;
        this.totalRecords = totalRecords;

        adjustPage();
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getPageNo() {
        return this.pageNo;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getTotalSize() {
        return this.totalSize;
    }

    public List<T> getPageRecords() {
        return this.pageRecords;
    }

    public void setPageRecords(List<T> pageRecords) {
        this.pageRecords = pageRecords;
        adjustPage();
    }

    public List<T> getTotalRecords() {
        return this.totalRecords;
    }

    public void setTotalRecords(List<T> totalRecords) {
        this.totalRecords = totalRecords;
        adjustPage();
    }

    public int getRecordSize() {
        return this.pageRecords == null?0:this.pageRecords.size();
    }

    public boolean isFirstPage() {
        return (this.pageNo == 1);
    }

    public boolean isLastPage() {
        return (this.pageNo == this.pageCount);
    }


}