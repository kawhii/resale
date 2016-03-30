package com.carl.resale.ui.dao;

import com.carl.resale.ui.bean.PageInfo;

/**
 * @author Carl
 * @date 2016/3/30
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public interface IPageSearch<O, P> {


    /**
     * 根据分页进行查询
     * @param page
     * @param pageSize
     * @param p 参数
     * @return
     */
    public PageInfo<O> getList(int page, int pageSize, P p);
}
