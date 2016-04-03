package com.carl.resale.ui.dao;

import com.carl.resale.ui.bean.Advantage;
import org.bson.types.ObjectId;

/**
 * 广告分类查询
 *
 * @author Carl
 * @date 2016/3/30
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public interface IAdvantageDao {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Advantage findById(ObjectId id);
}
