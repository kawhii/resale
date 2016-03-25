package com.carl.resale.ui.repositories;

import com.carl.resale.ui.bean.Category;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * 目录数据库操作
 * @author Carl
 * @date 2016/3/24
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Repository("categoryRepository")
public interface CategoryRepository extends MongoRepository<Category, ObjectId> {
}
