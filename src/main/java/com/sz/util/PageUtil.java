package com.sz.util;

import java.util.List;

public class PageUtil<T> {
    private long total;   //总记录数
    private List<T> rows; //当前页的数据
    private int pageSize; //每页的记录数
    private int pageTotals; //总页数
    private int pageIndex; //当前页


    public PageUtil(long total, List<T> rows, int pageSize, int pageTotals, int pageIndex) {
        this.total = total;
        this.rows = rows;
        this.pageSize = pageSize;
        this.pageTotals = pageTotals;
        this.pageIndex = pageIndex;
    }

    public PageUtil() {
    }
}
