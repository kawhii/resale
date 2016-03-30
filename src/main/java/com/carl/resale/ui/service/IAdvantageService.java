package com.carl.resale.ui.service;

import com.carl.resale.ui.bean.Advantage;
import com.carl.resale.ui.bean.PageInfo;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * 广告服务类
 * @author Carl
 * @date 2016/3/30
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public interface IAdvantageService {
    /**
     * 查询广告
     * @param page 查找页码
     * @param pageSize 页大小
     * @param cityId 城市
     * @param categoryId 目录
     * @param specificTypeId 指定类型
     * @param order 排序字段
     * @return
     */
    public PageInfo<Advantage> getList(int page, int pageSize, String cityId, String categoryId, String specificTypeId, Sort order);

}
