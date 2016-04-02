package com.carl.resale.ui.service.impl;

import com.carl.resale.ui.bean.Advantage;
import com.carl.resale.ui.bean.PageInfo;
import com.carl.resale.ui.dao.impl.AdvantageDao;
import com.carl.resale.ui.service.IAdvantageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
}
