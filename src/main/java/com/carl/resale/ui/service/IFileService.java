package com.carl.resale.ui.service;

import java.io.File;

/**
 *文件服务类
 *
 * @author Carl
 * @date 2016/3/28
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public interface IFileService {

    /**
     * 根据文件id以及文件类型获取文件
     * @param id
     * @param type
     * @return
     */
    public File getFileByIdAndType(String id, String type);

    /**
     * 获取文件路径
     * @param id
     * @param type
     * @return
     */
    public String getFilePathByIdAndType(String id, String type);
}
