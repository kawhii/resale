package com.carl.resale.ui.dao.impl;

import com.carl.resale.ui.bean.Categories;
import com.carl.resale.ui.dao.ICategoriesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Carl
 * @date 2016/3/19
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Component("categoriesDao")
public class CategoriesDao implements ICategoriesDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Categories> getHomePageCategories(int size) {
       return mongoTemplate.find(new Query().with(new Sort(Sort.Direction.ASC, "order")).limit(size), Categories.class);
    }
}
