package com.carl.resale.ui.service.impl;

import com.carl.resale.ui.bean.Category;
import com.carl.resale.ui.bean.ClassifiedsSearchParam;
import com.carl.resale.ui.bean.SysArea;
import com.carl.resale.ui.service.ICategoryService;
import com.carl.resale.ui.service.IClassifiedsSearchService;
import com.carl.resale.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分类查找实现
 * @author Carl
 * @date 2016/3/30
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Service("classifiedsSearchService")
public class ClassifiedsSearchService implements IClassifiedsSearchService {
    @Autowired
    private AreaService areaService;
    @Autowired
    private ICategoryService categoryService;

    @Override
    public Map<String, Object> search(ClassifiedsSearchParam param) {
        Map<String, Object> result = new HashMap<String, Object>();
        //获取当前地区
        List<SysArea> area = areaService.findAllHighest();
        //如果全部，才进行获取
        List<Category> category = categoryService.getHomeCategory(50);
        if(param != null) {
            result.put("cityId", param.getCityId());
            String categoryId  = param.getCategoryId();
            result.put("categoryId", categoryId);
            if(!StringUtil.isNull(categoryId)) {
                //如果有输入id查找详细
                result.put("categoryDetail", categoryService.findById(categoryId));
            }

        }
        result.put("listCategory", category);
        result.put("listArea", area);
        return result;
    }
}
