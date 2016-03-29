package com.carl.resale.ui.service.impl;

import com.carl.resale.ui.bean.SysArea;
import com.carl.resale.ui.repositories.SysAreaRepository;
import com.carl.resale.ui.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Carl
 * @date 2016/3/29
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@Service("areaService")
public class AreaService implements IAreaService {
    @Autowired
    private SysAreaRepository areaRepository;
    @Override
    public List<SysArea> findAllHighest() {
        return areaRepository.findLevelHighest();
    }
}
