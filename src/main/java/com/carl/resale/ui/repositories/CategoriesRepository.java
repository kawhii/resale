package com.carl.resale.ui.repositories;

import com.carl.resale.ui.bean.Categories;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Carl
 * @date 2016/3/23
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Repository("categoriesRepository")
public interface CategoriesRepository extends MongoRepository<Categories, ObjectId> {

    @Query(value = "{'name' : ?0}", fields = "{'code' : 0}")
    public List<Categories> findByHome(String name);
}
