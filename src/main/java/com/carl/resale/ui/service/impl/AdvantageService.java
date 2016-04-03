package com.carl.resale.ui.service.impl;

import com.carl.resale.ui.bean.*;
import com.carl.resale.ui.dao.impl.AdvantageDao;
import com.carl.resale.ui.service.IAdvantageService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询广告
 *
 * @author Carl
 * @date 2016/3/30
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Service("advantageService")
public class AdvantageService implements IAdvantageService {
    @Autowired
    private AdvantageDao advantageDao;

    @Override
    public PageInfo<Advantage> getList(int page, int pageSize, String cityId, String categoryId, String specificTypeId, String showTypeId, Sort order) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("cityId", cityId);
        param.put("categoryId", categoryId);
        param.put("specificTypeId", specificTypeId);
        param.put("showTypeId", showTypeId);
        param.put("order", order);
        return advantageDao.getList(page, pageSize, param);
    }

    @Override
    public Advantage findById(String id) {
        return advantageDao.findById(new ObjectId(id));
    }

    @Override
    public List<NavBar> getBarFormAdv(Advantage advantage) {
        List<NavBar> bars = new ArrayList<NavBar>();
        bars.add(new NavBar(null, null, "目录"));
        if(advantage != null) {
            Category c = advantage.getCategory();
            NavBar categoryBar = new NavBar("categoryId", c.getId().toString(), c.getName());
            bars.add(categoryBar);
            SpecificType specificType = advantage.getSpecificType();
            NavBar sftBar = new NavBar("specificTypeId", specificType.getId().toString(), specificType.getName()).addChildren(categoryBar);
            bars.add(sftBar);
        }
        return bars;
    }
}
