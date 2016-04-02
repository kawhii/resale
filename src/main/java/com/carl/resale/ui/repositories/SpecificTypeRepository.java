package com.carl.resale.ui.repositories;

import com.carl.resale.ui.bean.SpecificType;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Carl
 * @date 2016/3/31
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Repository("specificTypeRepository")
public interface SpecificTypeRepository extends MongoRepository<SpecificType, ObjectId> {
}
