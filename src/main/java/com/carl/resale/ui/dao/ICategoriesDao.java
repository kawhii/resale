package com.carl.resale.ui.dao;


import com.carl.resale.ui.bean.Categories;

import java.util.List;

/**
 * 获取品牌
 * @author Carl
 * @date 2016/3/19
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public interface ICategoriesDao {

    /**
     * 获取首页展示品牌
     * @param size 获取数量
     * @return
     */
    public List<Categories> getHomePageCategories(int size);
}
