package com.carl.resale.ui.bean;

import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * 分页数据情况
 *
 * @author Carl
 * @date 2016/3/30
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class PageInfo<O> {
    private Long total;
    private int page;
    private int pageSize;
    private List<O> rows;
    private Sort order;

    /**
     * 获取页码总数
     * @return
     */
    public long getPageCount() {
        if(total == 0) {
            return 0;
        }
        return (long) Math.ceil((double) (total / page));
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<O> getRows() {
        return rows;
    }

    public void setRows(List<O> rows) {
        this.rows = rows;
    }

    public Sort getOrder() {
        return order;
    }

    public void setOrder(Sort order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "total=" + total +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", rows=" + rows +
                ", order=" + order +
                '}';
    }
}
