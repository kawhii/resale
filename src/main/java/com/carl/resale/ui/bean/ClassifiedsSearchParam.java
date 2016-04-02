package com.carl.resale.ui.bean;

import com.carl.resale.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 参数查找
 *
 * @author Carl
 * @date 2016/3/30
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class ClassifiedsSearchParam {
    //对应排序对应关系
    private static Map<String, String> SORT_MAPPER = new HashMap<String, String>();
    private static String DEF_SORT = "publish_time";//默认排序

    static {
        SORT_MAPPER.put("view", "views");
        SORT_MAPPER.put("publish_time", "time");
    }

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
    private String order = DEF_SORT;
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

    /**
     * 根据前端的排序值获取实际排序字段
     * @param key
     * @param def
     * @return
     */
    public static String getSortColumn(String key, String def) {
        String val = SORT_MAPPER.get(key);
        return StringUtil.isNull(val) ? def : val;
    }

    public static String getSortColumn(String key) {
        String val = SORT_MAPPER.get(key);
        return StringUtil.isNull(val) ? DEF_SORT : val;
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
