package com.carl.resale.ui.ctrl.test;

import com.carl.resale.core.file.FilePathAdapter;
import com.carl.resale.ui.bean.*;
import com.carl.resale.ui.ctrl.BaseCtrl;
import com.carl.resale.ui.repositories.*;
import com.carl.resale.util.FileUtils;
import com.carl.resale.util.StringUtil;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Carl
 * @date 2016/3/28
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Controller()
@RequestMapping("/data")
public class InitDataCtrl extends BaseCtrl {
    @Autowired
    private SysFileRepository fileRepository;

    @Autowired
    private SysAreaRepository sysAreaRepository;

    @Autowired
    private AdvantageRepository advRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private HotAdvantageRepository hotAdvantageRepository;

    @Override
    protected String getModuleName() {
        return "init-data";
    }

    /**
     * 转发上传文件
     *
     * @param model
     * @return
     */
    @RequestMapping("/goUploadFile")
    public String goUploadFile(Model model) {
        SysFile f = new SysFile();
        f.setName("a.jpg");
        model.addAttribute("file", f);
        return JSP + getWarpModuleName() + "uploadFile";
    }

    /**
     * 转发上传文件
     *
     * @param model
     * @return
     */
    @RequestMapping("")
    public String goInit(Model model) {
        SysFile f = new SysFile();
        f.setName("a.jpg");
        model.addAttribute("file", f);
        return THYMELEAFE + getWarpModuleName() + "nav";
    }

    /**
     * 单一上传文件
     *
     * @param file
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/uploadFile")
    public String uploadFile(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) throws Exception {
        logger.info(file.getOriginalFilename());
        logger.info(file.getContentType());
        logger.info(file.getSize());
        FileUtils.save(file, new FilePathAdapter() {
            @Override
            public String path() {
                return "tyle";
            }
        });
        return null;
    }


    /**
     * 添加品牌上次文件
     *
     * @param brand
     * @param file
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("addBrand")
    public String addBrand(Category brand, @RequestParam(value = "file", required = false) MultipartFile file, Model model) throws Exception {
        if (brand != null && brand.getOrder() > 0) {
            final String businessType = "test";
            SysFile sysFile = FileUtils.save(file, new FilePathAdapter() {
                @Override
                public String path() {
                    return businessType;
                }
            });
            sysFile.setBusiType(businessType);
            fileRepository.insert(sysFile);
            brand.setImageId(sysFile.getId());
            brand.setImageType(sysFile.getType());
            mongoTemplate.insert(brand);
        }
        model.addAttribute("brand", new Category());
        return THYMELEAFE + SEPARATOR + "addBrand";
    }

    /**
     * 广告发布
     *
     * @return
     */
    @RequestMapping("publishAdvantage")
    public String publishAdvantage(Advantage advantage, @RequestParam(value = "file", required = false) MultipartFile file,int isHot, Model model)
            throws Exception {
        final String business = advantage.getBusiness();
        SysArea area = sysAreaRepository.findAll().get(0);
        advantage.setArea(area);
        SysFile sysFile = null;
        if (file != null && file.getSize() > 0) {
            sysFile = FileUtils.save(file, new FilePathAdapter() {
                @Override
                public String path() {
                    return business;
                }
            });
        }
        if (sysFile != null) {
            fileRepository.insert(sysFile);
            advantage.setPreviewImage(sysFile);
        }

        List<SysFile> files = new ArrayList<SysFile>();
        files.add(sysFile);
        files.add(sysFile);
        advantage.setDisplayImgs(files);
        Category c = categoryRepository.findAll().get(1);
        advantage.setCategory(c);
        if (c.getSpecTypes() != null) {
            advantage.setShowType(c.getShowTypes().get(1).getId());
        }
        if (c != null)
            advantage.setSpecificType(c.getSpecTypes().get(1));
        advRepository.insert(advantage);

        if(isHot == 1) {
            HotAdvantage hotAdvantage = new HotAdvantage();
            hotAdvantage.setAdvantage(advantage);
            hotAdvantage.setOrder(1);
            hotAdvantage.setState(new State());
            hotAdvantageRepository.insert(hotAdvantage);
        }

        return THYMELEAFE + getWarpModuleName() + "publishAdvantage";
    }

    /**
     * 目录上次图片
     *
     * @param model
     * @return
     */
    @RequestMapping("goPublishAdvantage")
    public String goPublishAdvantage(Model model) {
        model.addAttribute("advantage", new Advantage());
        return THYMELEAFE + getWarpModuleName() + "publishAdvantage";
    }

    /**
     * 目录上次图片
     *
     * @param model
     * @return
     */
    @RequestMapping("goAddBrand")
    public String goToAddBrand(Model model) {
        model.addAttribute("brand", new Category());
        return THYMELEAFE + SEPARATOR + "addBrand";
    }
}
