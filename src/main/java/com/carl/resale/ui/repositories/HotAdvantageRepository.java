package com.carl.resale.ui.repositories;

import com.carl.resale.ui.bean.HotAdvantage;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Carl
 * @date 2016/4/2
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Repository("hotAdvantageRepository")
public interface HotAdvantageRepository extends MongoRepository<HotAdvantage, ObjectId> {

    /**
     * 首页热门广告
     * @return
     */
    @Query(value = "{'state.code' : '1'}")
    public List<HotAdvantage> getHomePageHotAdv();
}
