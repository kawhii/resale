package com.carl.resale.ui.ctrl.welcome;

import com.carl.resale.ui.bean.Categories;
import com.carl.resale.ui.bean.Category;
import com.carl.resale.ui.service.ICategoriesDaoService;
import com.carl.resale.ui.service.ICategoryService;
import com.carl.resale.ui.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制器
 * @author Carl
 * @date 2016/3/18
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Controller
@RequestMapping("/")
public class HomePageCtrl {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private CategoryService categoryService;

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @RequestMapping("")
    public String index() {
        return "jsp/index";
    }

    @RequestMapping("addBrand")
    public String addBrand(Category brand, Model model) {
        if(brand != null && brand.getOrder() > 0)
            mongoTemplate.insert(brand);
        model.addAttribute("brand", new Category());
        return "thymeleafe/addBrand";
    }

    /**
     * 首页品牌
     * @param model
     * @return
     */
    @RequestMapping("index/brand")
    public String indexBrand(Model model) {
        model.addAttribute("brands", categoryService.getHomePageCategory(12));
        return "thymeleafe/home/brand";
    }

    /**
     * 底部
     * @return
     */
    @RequestMapping("index/footer")
    public String indexFooter() {
        return "jsp/home/footer";
    }

    /**
     * 头部
     * @return
     */
    @RequestMapping("index/header")
    public String indexHeader() {
        return "jsp/home/header";
    }

    /**
     * 头部
     * @return
     */
    @RequestMapping("index/main")
    public String indexMain() {
        return "jsp/home/main";
    }
}
