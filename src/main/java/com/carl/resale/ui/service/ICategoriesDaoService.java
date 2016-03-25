package com.carl.resale.ui.service;

import com.carl.resale.ui.bean.Categories;

import java.util.List;

/**
 * 品牌服务
 * @author Carl
 * @date 2016/3/19
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public interface ICategoriesDaoService {
    /**
     * 获取首页品牌
     * @param limit
     * @return
     */
    public List<Categories> getHomeCategories(int limit);
}
