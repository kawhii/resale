package com.carl.resale.ui.ctrl.sctipt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Carl
 * @date 2016/10/23
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Controller
@RequestMapping("/scriptTemplate")
public class SampleController {

    @RequestMapping("/test")
    public ModelAndView test() {
        System.out.println("SampleController.test");
        ModelAndView mav  = new ModelAndView();
        mav.addObject("title", "Sample title").addObject("body", "Sample body");
        mav.setViewName("mustache/test");
        return mav;
    }
}
