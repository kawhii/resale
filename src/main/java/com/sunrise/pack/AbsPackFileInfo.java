package com.sunrise.pack;

/**
 * 打包文件基础信息
 *
 * @author Carl
 * @date 2016/6/15
 * <p/>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public abstract class AbsPackFileInfo<T extends AbsPackFileInfo<T>> {
    private String name;//文件名
    private long offset;//偏移量
    private long length;//文件总长度
    private long lastModified;//最后修改时间

    private AbsPackFileIndex<T> index;


    public T name(String name) {
        if (name.startsWith("/"))
            this.name = name.substring(1);
        else
            this.name = name;
        return (T)this;
    }

    public T index(AbsPackFileIndex<T> index) {
        this.index = index;
        return (T)this;
    }

    public AbsPackFileIndex<T> index() {
        return this.index;
    }

    public T offset(long offset) {
        this.offset = offset;
        return (T)this;
    }

    public T length(long length) {
        this.length = length;
        return (T)this;
    }

    public T lastModified(long lastModified) {
        this.lastModified = lastModified;
        return (T)this;
    }

    public String name() {
        return this.name;
    }

    public long offset() {
        return this.offset;
    }

    public long length() {
        return this.length;
    }

    public long lastModified() {
        return this.lastModified;
    }
}
