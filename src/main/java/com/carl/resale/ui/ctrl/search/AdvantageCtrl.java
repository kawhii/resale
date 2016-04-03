package com.carl.resale.ui.ctrl.search;

import com.carl.resale.ui.bean.Advantage;
import com.carl.resale.ui.bean.Category;
import com.carl.resale.ui.bean.NavBar;
import com.carl.resale.ui.ctrl.BaseCtrl;
import com.carl.resale.ui.service.IAdvantageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 广告详情
 *
 * @author Carl
 * @date 2016/4/3
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Controller
@RequestMapping("/adv")
public class AdvantageCtrl extends BaseCtrl {
    @Autowired
    private IAdvantageService advantageService;
    @Override
    protected String getModuleName() {
        return "advantage";
    }

    /**
     * 详细内容
     * @param id
     * @return
     */
    @RequestMapping(value = "/detail/{id:\\w{24}}.html", method = {RequestMethod.GET})
    public ModelAndView getDetail(@PathVariable(value = "id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> result = new HashMap<String, Object>();
        Advantage advantage = advantageService.findById(id);
        if(advantage != null) {
            List<NavBar> bars = advantageService.getBarFormAdv(advantage);
            result.put("bars", bars);
        }
        modelAndView.addObject("result", result);
        modelAndView.addObject("adv", advantage);
        modelAndView.setViewName(JSP + getWarpModuleName() + "detail");
        return modelAndView;
    }

    /**
     * 主要转发freemarker
     * @return
     */
    @RequestMapping(value = "/mainContent", method = {RequestMethod.GET})
    public String mainContent() {
        return FREEMARKER + getWarpModuleName() + "mainContent";
    }
}
