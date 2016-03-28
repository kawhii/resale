package com.carl.resale.ui.service.impl;

import com.carl.resale.ui.bean.SysFile;
import com.carl.resale.ui.repositories.SysFileRepository;
import com.carl.resale.ui.service.IFileService;
import com.carl.resale.util.FileUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author Carl
 * @date 2016/3/28
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Service("fileService")
public class FileService implements IFileService {
    @Autowired
    private SysFileRepository fileRepository;

    @Override
    public File getFileByIdAndType(String id, String type) {
        SysFile file = fileRepository.findByIdAndType(new ObjectId(id), type);
        return FileUtils.convertSysFileToFile(file);
    }
}
