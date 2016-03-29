package com.carl.resale.ui.service;

import com.carl.resale.ui.bean.SysArea;

import java.util.List;

/**
 * 地区服务类
 * @author Carl
 * @date 2016/3/29
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public interface IAreaService {
    /**
     * 获取最高级别地区
     * @return
     */
    public List<SysArea> findAllHighest();
}
