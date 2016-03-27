package com.carl.resale.ui.dao;

import com.carl.resale.ui.bean.Category;

import java.util.List;

/**
 * @author Carl
 * @date 2016/3/27
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public interface ICategoryDao {
    /**
     * 获取首页展示品牌
     * @param size 获取数量
     * @return
     */
    public List<Category> getHomePageCategory(int size);

    /**
     * 查找用于目录点击tab切换
     * @param size
     * @return
     */
    public List<Category> findOnSearchDetail(int size);
}
