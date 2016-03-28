package com.carl.resale.util;

import com.carl.resale.core.Constants;
import com.carl.resale.core.FrameworkConfig;
import com.carl.resale.core.file.FilePathAdapter;
import com.carl.resale.ui.bean.SysFile;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;


/**
 * 文件操作工具了
 * @author Carl
 * @date 2016/3/28
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class FileUtils {
    private static Log log = LogFactory.getLog(FileUtils.class);

    /**
     * 文件保存
     * @param file 文件
     * @param adapter 获取路径适配器
     * @return
     * @throws Exception
     */
    public static SysFile save(MultipartFile file, FilePathAdapter adapter) throws Exception {
        log.debug("文件保存");
        String webRootPath = Constants.getWebRoot();
        String uploadFilePath = FrameworkConfig.getInstance().getParam("", "upload-files");
        String name = file.getOriginalFilename();
        String type = getFileExt(name);
        String fileName = UUID.get() + "." + type;
        String path = uploadFilePath + File.separator + adapter.path() + File.separator + fileName;
        path = path.replace('\\', '/');
        File targetFile = new File(webRootPath + path);
        if (!targetFile.exists()) {
            log.debug("路径不存在，准备创建目录[" + webRootPath + path + "]");
            targetFile.mkdirs();
        }
        file.transferTo(targetFile);
        log.debug("文件保存成功：[" + (webRootPath + path));

        SysFile returnFile = new SysFile();
        returnFile.setName(name);
        returnFile.setPath(path);
        returnFile.setSize(file.getSize());
        returnFile.setType(type);
        returnFile.setCreateTime(new Date());
        return returnFile;
    }

    /**
     * 利用系统文件转换成真实文件
     * @param file
     * @return
     */
    public static File convertSysFileToFile(SysFile file) {
        return new File(Constants.getWebRoot() + file.getPath());
    }

    /**
     * 获取文件后缀
     *
     * @param file
     * @return
     */
    public static String getFileExt(MultipartFile file) {
        String ext = null;
        if (file != null) {
            String name = file.getOriginalFilename();
            ext = getFileExt(name);
        }
        return ext;
    }

    /**
     * 获取文件后缀
     *
     * @param name 文件名字
     * @return
     */
    public static String getFileExt(String name) {
        String ext = null;
        if (!StringUtil.isNull(name)) {
            ext = name.substring(name.lastIndexOf(".") + 1).toLowerCase();
        }
        return ext;
    }
}
