package com.carl.resale.ui.ctrl.index;

import com.carl.resale.ui.ctrl.BaseCtrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Carl
 * @date 2016/11/19
 */
@Controller
@RequestMapping("/")
public class IndexCtrl extends BaseCtrl {
    @Override
    protected String getModuleName() {
        return "index";
    }

    /**
     * 主要转发freemarker
     * @return
     */
    @RequestMapping(value = "/index.html", method = {RequestMethod.GET})
    public String mainContent() {
        return freemarker("index");
    }
}
