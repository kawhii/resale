package com.carl.resale.ui.ctrl.search;

import com.carl.resale.ui.bean.Category;
import com.carl.resale.ui.bean.SysArea;
import com.carl.resale.ui.ctrl.BaseCtrl;
import com.carl.resale.ui.repositories.CategoriesRepository;
import com.carl.resale.ui.service.ICategoryService;
import com.carl.resale.ui.service.impl.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 广告分类
 * @author Carl
 * @date 2016/3/29
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Controller
@RequestMapping("/cf")
public class ClassifiedsCtrl extends BaseCtrl {
    @Autowired
    private AreaService areaService;

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("/search")
    public String search(@RequestParam(required = false)String cityId, @RequestParam(required = false) String categoryId, Model model) {
        //获取当前地区
        List<SysArea> area = areaService.findAllHighest();
        //如果全部，才进行获取
        List<Category> category = categoryService.getHomeCategory(50);
        model.addAttribute("cityId", cityId);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("listArea", area);
        model.addAttribute("listCategory", category);
        return JSP + getWarpModuleName() + "classifieds";
    }

    @RequestMapping("/body")
    public String body(Model model) {
        return FREEMARKER + getWarpModuleName() + "classifiedsBody";
    }

    @Override
    protected String getModuleName() {
        return "search";
    }
}
