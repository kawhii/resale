package com.carl.resale.ui.service.impl;

import com.carl.resale.ui.bean.Categories;
import com.carl.resale.ui.dao.ICategoriesDao;
import com.carl.resale.ui.service.ICategoriesDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Carl
 * @date 2016/3/19
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Service("categoriesService")
public class CategoriesService implements ICategoriesDaoService {
    @Autowired
    private ICategoriesDao categoriesDao;

    public void setBrandDao(ICategoriesDao brandDao) {
        this.categoriesDao = brandDao;
    }

    @Override
    public List<Categories> getHomeCategories(int limit) {
        return categoriesDao.getHomePageCategories(limit);
    }
}
