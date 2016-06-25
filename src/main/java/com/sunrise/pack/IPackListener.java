package com.sunrise.pack;

import java.io.File;

/**
 * 打包监听器
 * @author Carl
 * @date 2016/6/15
 * <p/>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public interface IPackListener {

    /**
     * 打包前执行
     */
    void onPackBefore();

    /**
     * 打包后执行
     */
    void onPackAfter(File file);

    /**
     * 读索引前执行
     * @param packFile
     */
    void onReadIndexBefore(File packFile);

    /**
     * 读取索引后执行
     * @param index
     */
    void onReadIndexAfter(AbsPackFileIndex index);

    /**
     * 读取文件信息前执行
     * @param packFile
     * @param name
     */
    void onReadInfoBefore(File packFile, String name);


    /**
     * 读取文件信息后执行
     * @param info
     */
    void onReadInfoAfter(AbsPackFileInfo info);
}
