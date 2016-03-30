package com.carl.resale.ui.bean;

/**
 * 参数查找
 * @author Carl
 * @date 2016/3/30
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class ClassifiedsSearchParam {
    private String cityId;
    private String categoryId;
    private int pageSize = 24;
    private int page;
    private String order;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "ClassifiedsSearchParam{" +
                "cityId='" + cityId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", pageSize=" + pageSize +
                ", page=" + page +
                ", order='" + order + '\'' +
                '}';
    }
}
