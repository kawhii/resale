package com.carl.resale.ui.service.impl;

import com.carl.resale.ui.bean.*;
import com.carl.resale.ui.service.IAdvantageService;
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

    @Autowired
    private IAdvantageService advantageService;

    @Override
    public Map<String, Object> search(ClassifiedsSearchParam param) {
        Map<String, Object> result = new HashMap<String, Object>();
        //获取当前地区
        List<SysArea> area = areaService.findAllHighest();
        //如果全部，才进行获取
        List<Category> category = categoryService.getHomeCategory(50);
        //获取页码
        int page = ClassifiedsSearchParam.DEFAULT_PAGE;
        int pageSize = ClassifiedsSearchParam.DEFAULT_PAGE_SIZE;
        //查询条件
        String categoryId = null, cityId = null, specificTypeId = null;
        if(param != null) {
            categoryId  = param.getCategoryId();
            cityId  = param.getCityId();
            specificTypeId  = param.getSpecificTypeId();

            result.put("cityId", param.getCityId());
            result.put("categoryId", categoryId);
            result.put("specificTypeId", specificTypeId);
            if(!StringUtil.isNull(categoryId)) {
                //如果有输入id查找详细
                result.put("categoryDetail", categoryService.findById(categoryId));
            }
        }
        //查询列表信息
        PageInfo<Advantage> body = advantageService.getList(page, pageSize, cityId, categoryId, specificTypeId, null);
        result.put("listCategory", category);
        result.put("listArea", area);
        result.put("body", body);
        return result;
    }
}
