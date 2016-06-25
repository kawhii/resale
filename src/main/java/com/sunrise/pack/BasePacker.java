package com.sunrise.pack;

import com.sunrise.foundation.utils.StringUtil;
import com.sunrise.framework.core.Log;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 基础的打包工具
 *
 * @author Carl
 * @date 2016/6/15
 * <p/>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public abstract class BasePacker<I extends AbsPackFileIndex<F>, F extends AbsPackFileInfo<F>> implements IPacker<I, F> {
    private String ext;//文件后缀
    private boolean isPacking;//是否正在打包
    private boolean deleteAfterPack;//是否打包后删除
    private List<String> excludePatterns = new ArrayList<String>();//文件后缀不打包类型
    private String packName;//打包文件名
    private File output;//打包输出目录
    private IPackCrypter crypter;//加密算法
    private FileFilter fileFilter;//文件夹过滤器
    private IOFileFilter excludeFilter;

    /**
     * 文件塞选模式
     */
    private FileSelection fileSelection = FileSelection.EXCLUDE;

    //打包监听器
    private IPackListener listener;

    /**
     * 获取当前跟路径
     */
    protected final String rootPath = getClass().getResource("/").getFile().toString();//取得根目录路径

    /**
     * 默认的文件过滤器
     */
    private IOFileFilter DEF_EXCLUDE_FILTER = new IOFileFilter() {
        @Override
        public boolean accept(File file) {
            if (file.isDirectory())
                return true;
            //如果是模块配置文件，则不进行打包
            String name = file.getName();
            String base = FilenameUtils.getBaseName(file.getName());
            String ext = FilenameUtils.getExtension(file.getName());

            for (String e : getExcludePatterns()) {
                if (StringUtil.matchPattern(name, e))
                    return fileSelection == FileSelection.INCLUDE;
            }
            return fileSelection != FileSelection.INCLUDE;
        }

        @Override
        public boolean accept(File dir, String name) {
            //如果是模块配置文件，则不进行打包
            String base = FilenameUtils.getBaseName(name);
            String ext = FilenameUtils.getExtension(name);


            for (String e : getExcludePatterns()) {
                if (StringUtil.matchPattern(name, e))
                    return fileSelection == FileSelection.INCLUDE;
            }
            return fileSelection != FileSelection.INCLUDE;
        }
    };


    @Override
    public BasePacker fileExt(String ext) {
        this.ext = ext;
        return this;
    }

    @Override
    public boolean isPacking() {
        return isPacking;
    }

    @Override
    public BasePacker deleteAfterPack(boolean delete) {
        this.deleteAfterPack = delete;
        return this;
    }

    @Override
    public BasePacker excludePatterns(FileSelection fileSelection, String... patterns) {
        if (fileSelection != null) {
            this.fileSelection = fileSelection;
        }
        for (String t : patterns) excludePatterns.add(StringUtil.wildcard2Reg(t));
        return this;
    }

    @Override
    public BasePacker packName(String name) {
        this.packName = name;
        return this;
    }

    @Override
    public BasePacker output(File output) {
        this.output = output;
        return this;
    }

    @Override
    public BasePacker crypter(IPackCrypter crypter) {
        this.crypter = crypter;
        return this;
    }

    @Override
    public BasePacker folderFilter(FileFilter filter) {
        this.fileFilter = filter;
        return this;
    }

    protected String getExt() {
        return ext;
    }

    protected boolean isDeleteAfterPack() {
        return deleteAfterPack;
    }

    protected List<String> getExcludePatterns() {
        return excludePatterns;
    }

    protected String getPackName() {
        return packName;
    }

    protected File getOutput() {
        if (output == null || !output.exists()) {
            return new File(rootPath);
        }
        return output;
    }

    protected IPackCrypter getCrypter() {
        return crypter;
    }

    protected FileFilter getFolderFilter() {
        return fileFilter;
    }


    protected IOFileFilter getExcludeFilter() {
        excludeFilter = excludeFilter == null ? DEF_EXCLUDE_FILTER : excludeFilter;
        return excludeFilter;
    }

    /**
     * 构建输出流
     *
     * @param packFile 打包文件
     * @return
     * @throws java.io.FileNotFoundException
     */
    protected final DataOutputStream buildOutputStream(File packFile) throws FileNotFoundException {
        return new DataOutputStream(
                new PackOutputStream(new FileOutputStream(packFile),
                        null == crypter ? DEFAULT_CRYPTER : crypter));
    }

    /**
     * 构建输出流
     *
     * @param packFile 打包文件
     * @return
     * @throws java.io.FileNotFoundException
     */
    protected final DataInputStream buildInputStream(File packFile) throws FileNotFoundException {
        return new DataInputStream(
                new PackInputStream(new FileInputStream(packFile),
                        null == crypter ? DEFAULT_CRYPTER : crypter));
    }


    @Override
    public InputStream getFileInputStream(File packFile, F info) throws IOException {
        //TODO:获取文件输入流
        return null;
    }

    @Override
    public final synchronized void pack(String path) throws Exception {
        try {
            if (listener != null)
                listener.onPackBefore();

            isPacking = true;

            //如果没有指定输出目录，则默认使用运行时目录
            if (output == null) {
                output = new File(rootPath);
            }
            packFiles(path);
        } finally {
            isPacking = false;
        }

        if (listener != null)
            listener.onPackAfter(new File(output, getFullPackName()));
    }

    /**
     * 打包所有文件
     *
     * @param path
     */
    protected abstract void packFiles(String path) throws Exception;

    /**
     * 获取全部打包文件名
     *
     * @return
     */
    public String getFullPackName() {
        return getPackName() + "." + getExt();
    }

    /**
     * 把索引的头部进行输出
     *
     * @param index
     * @param outputStream
     * @throws java.io.IOException
     */
    protected final void write(I index, Collection<File> allFiles, DataOutputStream outputStream) throws IOException {
        writeIndexHeader(index, outputStream);

        //输出索引文件信息
        for (F f : index.files()) {
            writeFileInfo(f, outputStream);
        }
        outputStream.flush();

        //输出文件信息
        writeFiles(allFiles, outputStream);

        //刷新并关闭输出流
        outputStream.flush();
        outputStream.close();
    }

    //输出索引头部
    private void writeIndexHeader(I index, DataOutputStream outputStream) throws IOException {
        //输出索引头部
        outputStream.writeLong(index.length());
        outputStream.writeInt(index.typeLen());
        outputStream.write(index.type().getBytes());
        writeIndexHeaderExtend(index, outputStream);
    }

    /**
     * 读取扩展头部
     * @param index
     * @param outputStream
     * @throws java.io.IOException
     */
    protected void writeIndexHeaderExtend(I index, DataOutputStream outputStream) throws IOException {

    }

    /**
     * 写入文件信息，前面的都是一致的
     *
     * @param f
     * @param out
     * @throws java.io.IOException
     */
    private void writeFileInfo(F f, DataOutputStream out) throws IOException {
        byte[] tmp = f.name().getBytes();
        out.writeInt(tmp.length);
        out.write(tmp, 0, tmp.length);
        out.writeLong(f.offset());
        out.writeLong(f.length());
        out.writeLong(f.lastModified());
        writeFileInfoExtend(f, out);
    }

    /**
     * 写入文件扩展信息，前面以 <[文件名长度(4字节)][文件名][文件偏移字节(8字节)][文件大小(8字节)][文件最后修改日期(8字节)]>
     *
     * @param f
     * @param out
     * @throws java.io.IOException
     */
    protected void writeFileInfoExtend(F f, DataOutputStream out) throws IOException {
    }

    /**
     * 文件内容复制到包里面
     *
     * @param files
     * @param outputStream
     * @throws java.io.IOException
     */
    protected void writeFiles(Collection<File> files, DataOutputStream outputStream) throws IOException {
        //开始将文件内容复制到包里面
        for (File f : files) {
            Log.debug("正在打包文件 " + f.getAbsolutePath());
            FileUtils.copyFile(f, outputStream);
        }

        //打包后删除
        if (deleteAfterPack) {
            for (File f : files) {
                //TODO 测试阶段先不做删除
                //f.delete();
            }
        }
    }

    /**
     * 读取索引头
     *
     * @param index
     * @param in
     * @return 返回头部占用长度
     * @throws java.io.IOException
     */
    protected final long readeIndexHeader(I index, DataInputStream in) throws IOException, IllegalAccessException {
        //读取总长度
        long idxLen = in.readLong();
        //读取打包类型长度
        int packTypeLen = in.readInt();
        //读取打包类型
        byte[] buf = new byte[packTypeLen];
        in.read(buf, 0, buf.length);
        String packType = new String(buf);

        //判断不同类型，直接抛出异常
        if (!index.type().equals(packType)) {
            throw new IllegalAccessException("文件类型不正确 包类型[" + packType + "] 期望类型[" + index.type() + "]");
        }
        index.length(idxLen);
        return 8 + 4 + packTypeLen + readIndexHeaderExtend(index, in);
    }

    /**
     * 读取扩展头部
     * @param index
     * @param in
     * @return
     */
    protected long readIndexHeaderExtend(I index, DataInputStream in) throws IOException {
        return 0;
    }

    /**
     * 读取文件信息
     *
     * @return
     * @throws java.io.IOException
     */
    protected final long readFileInfo(F info, DataInputStream in) throws IOException {
        long read = 0;
        int nLen = in.readInt();
        if(nLen < 0) {
            throw new IOException("文件损坏：" + info.index().packFile().getAbsolutePath());
        }
        if (nLen > 20480) {
            //不正确的文件信息
            throw new IOException("发现不正确的文件索引信息，请重新打包：文件名长度大于 2048 字节");
        }
        byte[] nByte = new byte[nLen];
        in.readFully(nByte);
        info.name(new String(nByte));
        info.offset(in.readLong());
        info.length(in.readLong());
        info.lastModified(in.readLong());
        read += 4 + nLen + 8 + 8 + 8;
        read += readFileInfoExtend(info, in);
        return read;
    }

    /**
     * 读入文件扩展信息，前面以 <[文件名长度(4字节)][文件名][文件偏移字节(8字节)][文件大小(8字节)][文件最后修改日期(8字节)]>
     *
     * @param f
     * @param in
     * @return 已读长度
     * @throws java.io.IOException
     */
    protected long readFileInfoExtend(F f, DataInputStream in) throws IOException {
        return 0;
    }

    /**
     * 列出该所有文件，除去排除的文件类型
     *
     * @param dir
     * @return
     */
    protected Collection<File> allFiles(File dir) {
        return FileUtils.listFiles(dir, getExcludeFilter(), TrueFileFilter.INSTANCE);
    }

    @Override
    public IPacker listener(IPackListener listener) {
        this.listener = listener;
        return this;
    }

    @Override
    public final I readIndex(File packFile) throws IOException {
        if (listener != null)
            listener.onReadIndexBefore(packFile);
        I index = null;
        try {
            index = index(packFile);
            return index;
        } finally {
            if (listener != null)
                listener.onReadIndexAfter(index);
        }
    }

    /**
     * 通过文件获取索引
     *
     * @param packFile
     * @return
     * @throws java.io.IOException
     */
    protected abstract I index(File packFile) throws IOException;

    @Override
    public final F readInfo(File packFile, String name) throws IOException {
        if (listener != null)
            listener.onReadInfoBefore(packFile, name);
        F info = null;
        try {
            info = fileInfo(packFile, name);
            return info;
        } finally {
            if (listener != null)
                listener.onReadInfoAfter(info);
        }
    }

    /**
     * 读取文件信息
     *
     * @param packFile
     * @param name
     * @return
     */
    protected abstract F fileInfo(File packFile, String name) throws IOException;

    @Override
    public void copyFileContent(F info, OutputStream out) throws IOException {
        File packFile = info.index() == null ? null : info.index().packFile();
        if (null == packFile || !packFile.exists() || !packFile.isFile())
            return;

        RandomAccessFile raf = new RandomAccessFile(packFile, "r");

        int read = 0;
        int cread;
        raf.seek(info.offset());
        byte[] buf = new byte[20480];
        while (read < info.length()) {
            cread = (info.length() - read) >= buf.length ? buf.length : (int) (info.length() - read);
            raf.read(buf, 0, cread);
            //进行解密
            if (null != crypter) for (int i = 0; i < cread; i++) buf[i] = crypter.update(buf[i]);
            out.write(buf, 0, cread);
            read += cread;
            out.flush();
        }
        raf.close();
    }

    @Override
    public byte[] readFileContent(F info) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        copyFileContent(info, out);

        return out.toByteArray();
    }
}
