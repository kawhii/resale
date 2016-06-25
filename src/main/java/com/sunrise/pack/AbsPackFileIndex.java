package com.sunrise.pack;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 打包文件索引
 * <p/>
 * [索引总长度(8字节)][打包类型长度(4字节)][打包类型]
 *
 * @author Carl
 * @date 2016/6/15
 * <p/>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public abstract class AbsPackFileIndex<T extends AbsPackFileInfo<T>> {
    //索引的长度
    private long length;
    //打包文件
    private File packFile;


    private List<T> files = new ArrayList<T>();
    private Map<String, T> FILE_MAP = new HashMap<String, T>();


    protected AbsPackFileIndex packFile(File packFile) {
        this.packFile = packFile;
        return this;
    }

    protected final AbsPackFileIndex length(long length) {
        this.length = length;
        return this;
    }

    /**
     * 添加文件
     * @param info
     * @return
     */
    public final AbsPackFileIndex add(T info) {
        files.add(info);
        info.index(this);
        FILE_MAP.put(info.name(), info);
        return this;
    }

    public File packFile() {
        return this.packFile;
    }

    public long length() {
        return length;
    }

    /**
     * 获取所有文件
     * @return
     */
    public List<T> files() {
        return files;
    }

    /**
     * 获取打包类型长度
     * @return
     */
    public final int typeLen() {
        return type().getBytes().length;
    }

    /**
     * 索引类型
     * @return
     */
    public abstract String type();

    private void addFileInfo(T info) {
        files.add(info);
        info.index(this);
        //计算总长度
        //[索引总长度(8字节)][打包类型长度(4字节)][打包类型][后续自定义]
        length = 8 + 4 + type().getBytes().length + extendHeaderLength();
        for (T f : files) {
            length += fileInfoLength(f);//4 + f.name().getBytes().length + 8 + 8 + 8;
        }
    }

    /**
     * 扩展获取长度
     * @return
     */
    protected int extendHeaderLength() {
        return 0;
    }

    /**
     * 文件存储方式长度，读的时候是根据存储的方式进行读取
     * @param info
     * @return
     */
    protected abstract long fileInfoLength(T info);

    /**
     * 更新所有文件的偏移字节
     */
    private void updateOffsets() {
        long lastOffset = length;
        for (T f : files) {
            f.offset(lastOffset);
            lastOffset += f.length();
        }
    }

    /**
     * 添加文件
     *
     * @param files
     * @return
     */
    public final AbsPackFileIndex file(T... files) {
        for (T f : files) {
            addFileInfo(f);
        }

        updateOffsets();
        return this;
    }


    public T file(String name) {
        return FILE_MAP.get(name);
    }
}
