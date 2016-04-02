package com.carl.resale.ui.service.impl;

import com.carl.resale.ui.bean.*;
import com.carl.resale.ui.service.IAdvantageService;
import com.carl.resale.ui.service.ICategoryService;
import com.carl.resale.ui.service.IClassifiedsSearchService;
import com.carl.resale.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分类查找实现
 *
 * @author Carl
 * @date 2016/3/30
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Service("classifiedsSearchService")
public class ClassifiedsSearchService implements IClassifiedsSearchService {
    //目录id
    protected static final String CATEGORY_ID = "categoryId";
    //城市
    protected static final String CITY_ID = "cityId";
    //目录的下一级
    protected static final String SPECIFIC_TYPE_ID = "specificTypeId";
    //展示类型
    protected static final String SHOW_TYPE_ID = "showTypeId";

    //排序
    protected static final String ORDER_ID = "order";
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
        int page = param.getPage();
        int pageSize = param.getPageSize();
        //查询条件
        String categoryId = null, cityId = null, specificTypeId = null, showTypeId = null;//tab标签
        List<NavBar> bars = new ArrayList<NavBar>();//导航栏
        bars.add(new NavBar(null, null, "目录"));
        NavBar categoryBar = null;
        if (param != null) {
            categoryId = param.getCategoryId();
            cityId = param.getCityId();
            specificTypeId = param.getSpecificTypeId();
            showTypeId = param.getShowTypeId();

            result.put(CITY_ID, param.getCityId());
            result.put(CATEGORY_ID, categoryId);
            result.put(SPECIFIC_TYPE_ID, specificTypeId);
            result.put(SHOW_TYPE_ID, showTypeId);
            result.put(ORDER_ID, param.getOrder());
            if (!StringUtil.isNull(categoryId)) {
                //如果有输入id查找详细
                Category c = categoryService.findById(categoryId);
                categoryBar = new NavBar(CATEGORY_ID, c.getId().toString(), c.getName());
                bars.add(categoryBar);
                result.put("categoryDetail", c);
                //添加导航信息
                if (!StringUtil.isNull(specificTypeId)) {
                    if (!StringUtil.isNull(specificTypeId)) {
                        List<SpecificType> specificTypes = c.getSpecTypes();
                        for(SpecificType st : specificTypes) {
                            if(specificTypeId.equals(st.getId().toString())) {
                                if (st != null) {
                                    bars.add(new NavBar(SPECIFIC_TYPE_ID, st.getId().toString(), st.getName()).addChildren(categoryBar));
                                }
                            }
                        }
                    }
                }
            }
        }
        Sort sort = new Sort(Sort.Direction.DESC, ClassifiedsSearchParam.getSortColumn(param.getOrder()));
        //查询列表信息
        PageInfo<Advantage> body = advantageService.getList(page, pageSize, cityId, categoryId, specificTypeId, showTypeId, sort);
        result.put("listCategory", category);
        result.put("listArea", area);
        result.put("bars", bars);//导航栏
        result.put("body", body);
        return result;
    }
}
