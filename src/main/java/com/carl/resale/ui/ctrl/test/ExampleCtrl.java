package com.carl.resale.ui.ctrl.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Carl
 * @date 2016/3/18
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Controller
@RequestMapping("/example")
public class ExampleCtrl {
    @RequestMapping("/index")
    public String index() {
        return "jsp/index";
    }
}
