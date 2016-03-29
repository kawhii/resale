package com.carl.resale.ui.dao.impl;

import com.carl.resale.ui.bean.Category;
import com.carl.resale.ui.dao.BaseDao;
import com.carl.resale.ui.dao.ICategoryDao;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Carl
 * @date 2016/3/27
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Component("categoryDao")
public class CategoryDao extends BaseDao implements ICategoryDao {
    @Override
    public List<Category> getHomePageCategory(int size) {
        Query q = new Query();
        q.fields().include("id").include("name").include("cssName");
        return getMongoTemplate().find(q.with(new Sort(Sort.Direction.ASC, "order")).limit(size), Category.class);
    }

    @Override
    public List<Category> findOnSearchDetail(int size) {
        Query q = new Query();
        q.fields().include("id").include("name").include("imageId").include("specTypes").include("goodsCount").include("imageType");
        return getMongoTemplate().find(q.with(new Sort(Sort.Direction.ASC, "order")).limit(size), Category.class);
    }
}
