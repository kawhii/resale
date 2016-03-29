package com.carl.resale.ui.repositories;

import com.carl.resale.ui.bean.SysArea;
import com.carl.resale.ui.bean.SysFile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 地区查询
 * @author Carl
 * @date 2016/3/29
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Repository("areaRepository")
public interface SysAreaRepository extends MongoRepository<SysArea, ObjectId> {
    /**
     * 查询最高级别的城市
     * @return
     */
    @Query(value = "{'level' : 1}")
    public List<SysArea> findLevelHighest();
}
