package com.carl.resale.ui.ctrl.search;

import com.carl.resale.ui.bean.ClassifiedsSearchParam;
import com.carl.resale.ui.ctrl.BaseCtrl;
import com.carl.resale.ui.service.IClassifiedsSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    private IClassifiedsSearchService classifiedsSearchService;

    @RequestMapping("/search")
    public String search(ClassifiedsSearchParam param, Model model) {
        model.addAttribute("result", classifiedsSearchService.search(param));
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
