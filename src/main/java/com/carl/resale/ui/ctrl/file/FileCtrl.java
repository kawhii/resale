package com.carl.resale.ui.ctrl.file;

import com.carl.resale.ui.ctrl.BaseCtrl;
import com.carl.resale.ui.service.impl.FileService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 常量类
 *
 * @author Carl
 * @date 2016/3/28
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Controller
@RequestMapping("file")
public class FileCtrl extends BaseCtrl {
    @Autowired
    private FileService fileService;

    @RequestMapping("img/{id}.{type}")
    @ResponseBody
    public void getImage(@PathVariable String id, @PathVariable String type, HttpServletResponse res) {
        File file = fileService.getFileByIdAndType(id, type);
        res.setContentType("image/" + type);
        try {
            write(res, file);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    /**
     * 写出文件
     * @param res
     * @param file
     * @throws IOException
     */
    private void write(HttpServletResponse res, File file) throws IOException {
        OutputStream os = res.getOutputStream();
        try {
            res.reset();
            res.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
            res.setCharacterEncoding("UTF-8");
//            res.setContentType("application/octet-stream; charset=utf-8");
            os.write(FileUtils.readFileToByteArray(file));
            os.flush();
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }

    @Override
    protected String getModuleName() {
        return "file";
    }
}
