package com.carl.resale.ui.service;

import com.carl.resale.ui.bean.Advantage;
import com.carl.resale.ui.bean.ClassifiedsSearchParam;

import java.util.List;
import java.util.Map;

/**
 * 广告分类 服务类
 * @author Carl
 * @date 2016/3/30
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public interface IClassifiedsSearchService {
    /**
     * 搜索返回参数
     * @param param
     * @return
     */
    public Map<String, Object> search(ClassifiedsSearchParam param);
}
