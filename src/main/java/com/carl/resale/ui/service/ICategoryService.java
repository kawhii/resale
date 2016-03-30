package com.carl.resale.ui.service;

import com.carl.resale.ui.bean.Category;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * @author Carl
 * @date 2016/3/27
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public interface ICategoryService {
    /**
     * 获取首页品牌
     * @param limit
     * @return
     */
    public List<Category> getHomeCategory(int limit);

    /**
     * 获取搜索标签栏
     * @param limit
     * @return
     */
    public List<Category> findOnSearchDetail(int limit);

    /**
     * 根据id唯一查询
     * @param id
     * @return
     */
    public Category findById(String id);
}
