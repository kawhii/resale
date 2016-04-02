package com.carl.resale.ui.bean;

/**
 * 参数查找
 * @author Carl
 * @date 2016/3/30
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class ClassifiedsSearchParam {
    /**
     * 默认第一页
     */
    public static final int DEFAULT_PAGE = 1;
    /**
     * 默认24个一页
     */
    public static final int DEFAULT_PAGE_SIZE = 6;
    private String cityId;
    private String categoryId;
    private int pageSize = DEFAULT_PAGE_SIZE;
    private int page = DEFAULT_PAGE;
    private String order;
    private String specificTypeId;
    private String showTypeId;//tab 标签id

    public String getShowTypeId() {
        return showTypeId;
    }

    public void setShowTypeId(String showTypeId) {
        this.showTypeId = showTypeId;
    }

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

    public String getSpecificTypeId() {
        return specificTypeId;
    }

    public void setSpecificTypeId(String specificTypeId) {
        this.specificTypeId = specificTypeId;
    }

    @Override
    public String toString() {
        return "ClassifiedsSearchParam{" +
                "cityId='" + cityId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", pageSize=" + pageSize +
                ", page=" + page +
                ", specificTypeId=" + specificTypeId +
                ", order='" + order + '\'' +
                '}';
    }
}
