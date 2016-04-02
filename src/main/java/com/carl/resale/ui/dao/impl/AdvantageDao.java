package com.carl.resale.ui.dao.impl;

import com.carl.resale.ui.bean.Advantage;
import com.carl.resale.ui.bean.PageInfo;
import com.carl.resale.ui.dao.BaseDao;
import com.carl.resale.ui.dao.IAdvantageDao;
import com.carl.resale.ui.dao.IPageSearch;
import com.carl.resale.ui.repositories.AdvantageRepository;
import com.carl.resale.util.StringUtil;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * @author Carl
 * @date 2016/3/30
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Component("advantageDao")
public class AdvantageDao extends BaseDao implements IAdvantageDao, IPageSearch<Advantage, Map<String, Object>> {
    @Autowired
    private AdvantageRepository advantageRepository;
    @Override
    public PageInfo<Advantage> getList(int page, int pageSize, Map<String, Object> stringObjectMap) {
        Query query = new Query();
        String categoryId = (String) stringObjectMap.get("categoryId");
        String cityId = (String) stringObjectMap.get("cityId");
        String specificTypeId = (String) stringObjectMap.get("specificTypeId");
        String showTypeId = (String) stringObjectMap.get("showTypeId");
        Sort order = (Sort) stringObjectMap.get("order");
        if (!StringUtil.isNull(cityId)) {
            query.addCriteria(where("area.$id").is(new ObjectId(cityId)));
        }
        if (!StringUtil.isNull(categoryId)) {
            query.addCriteria(where("category.$id").is(new ObjectId(categoryId)));
        }

        if (!StringUtil.isNull(specificTypeId)) {
            query.addCriteria(where("specific_type.$id").is(new ObjectId(specificTypeId)));
        }
        if (!StringUtil.isNull(showTypeId)) {
            query.addCriteria(where("showType").is(new ObjectId(showTypeId)));
        }
        //计算总数
        long total = getMongoTemplate().count(query, Advantage.class);
        query.fields().include("id").include("business").
                include("title").include("publishTime").
                include("area").include("brand").include("specificType").
                include("previewImage").include("category").include("price");
        //排序分页
        query.with(new PageRequest(page - 1, pageSize));
        if (order == null) {
            order = new Sort(Sort.Direction.DESC, "publishTime");
        }
        query.with(order);
        List<Advantage> rows = getMongoTemplate().find(query, Advantage.class);
        PageInfo info = new PageInfo();
        info.setOrder(order);
        info.setPage(page);
        info.setRows(rows);
        info.setTotal((int)total);
        info.setPageSize(pageSize);
        return info;
    }
}
