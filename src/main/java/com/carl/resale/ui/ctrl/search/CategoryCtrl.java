package com.carl.resale.ui.ctrl.search;

import com.carl.resale.ui.ctrl.BaseCtrl;
import com.carl.resale.ui.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 目录操作
 *
 * @author Carl
 * @date 2016/3/27
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Controller
@RequestMapping("/category")
public class CategoryCtrl extends BaseCtrl {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public String mainCategories(@RequestParam(required = false) String id, Model model) {
        //当前选择的目录id
        model.addAttribute("id", id);
        model.addAttribute("categories", categoryService.findOnSearchDetail(12));
        return JSP + getWarpModuleName() + "mainCategory";
    }

    @RequestMapping("/main")
    public String main() {
        return FREEMARKER + getWarpModuleName() + "mainCategoryContent";
    }

    @Override
    protected String getModuleName() {
        return "search";
    }
}
