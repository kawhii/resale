package com.sunrise.pack;



import java.io.*;

/**
 * 打包文件对象
 *
 * @author Carl
 * @date 2016/6/15
 * <p/>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public interface IPacker<I, F> {

    /**
     * 文件塞选
     */
    public static enum FileSelection {
        /**
         * 包含
         */
        INCLUDE,
        /**
         * 取出
         */
        EXCLUDE
    }

    /**
     * 默认加密
     */
    public static final IPackCrypter DEFAULT_CRYPTER = new DoNothingPackCrypter();

    /**
     * 文件后缀
     *
     * @param ext
     * @return
     */
    public IPacker fileExt(String ext);

    /**
     * 是否正在打包
     *
     * @return
     */
    public boolean isPacking();

    /**
     * 根据文件信息输出到流
     * @param out
     * @throws java.io.IOException
     */
    public void copyFileContent(F info, OutputStream out) throws IOException;

    /**
     * 读取文件内容，输出byte
     * @param info
     * @return
     * @throws java.io.IOException
     */
    public byte[] readFileContent(F info) throws IOException;

    /**
     * 添加打包监听器
     *
     * @param listener
     * @return
     */
    public IPacker listener(IPackListener listener);

    /**
     * 打包后是否删除
     *
     * @param delete
     * @return
     */
    public IPacker deleteAfterPack(boolean delete);

    /**
     * 要排除的文件类型
     *
     * @param selection 文件塞选模式
     * @param patterns
     * @return
     */
    public IPacker excludePatterns(FileSelection selection, String... patterns);

    /**
     * 打包文件名
     *
     * @param name
     * @return
     */
    public IPacker packName(String name);


    /**
     * 输出路径
     *
     * @param output
     * @return
     */
    public IPacker output(File output);

    /**
     * 打包执行
     *
     * @param path 打包搜索文件路径
     * @throws Exception
     */
    public void pack(String path) throws Exception;

    /**
     * 根据打包文件进行读取索引
     *
     * @param packFile
     * @return
     * @throws java.io.IOException
     */
    public I readIndex(File packFile) throws IOException;

    /**
     * 根据打包文件进行读取文件信息
     *
     * @param packFile 打包文件
     * @param name     存储文件名
     * @return
     * @throws java.io.IOException
     */
    public F readInfo(File packFile, String name) throws IOException;

    /**
     * @param crypter
     * @return
     */
    public IPacker crypter(IPackCrypter crypter);

    /**
     * 文件夹过滤器
     *
     * @return
     */
    public IPacker folderFilter(FileFilter filter);

    /**
     * 根据打包文件以及文件信息获取文件流
     *
     * @param packFile
     * @param info
     * @return
     * @throws java.io.IOException
     */
    public InputStream getFileInputStream(File packFile, F info) throws IOException;
}
