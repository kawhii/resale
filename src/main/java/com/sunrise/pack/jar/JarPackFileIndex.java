package com.sunrise.pack.jar;

import com.sunrise.pack.AbsPackFileIndex;

import java.io.File;

/**
 * [索引总长度(8字节)][索引总长度(4字节)][打包类型长度(8字节)][打包类型][版本号长度(4字节)][版本号][序列号长度(4字节)][序列号]
 *  <[文件名长度(4字节)][文件名][文件偏移字节(8字节)][文件大小(8字节)][文件最后修改日期(8字节)]>
 *     Jar包打包的文件索引
 * @author Carl
 * @date 2016/6/15
 * <p/>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class JarPackFileIndex extends AbsPackFileIndex<JarPackFileInfo> {
    private int versionLen = 0;//版本号长度
    private String versionCode;//版本编码
    private int sequenceLen = 0;//序列号长度
    private String sequence;//序列号
    private JarPackFileIndex(File packFile) {
        if(packFile == null || !packFile.exists()) {
            throw new IllegalArgumentException("pack file must exists");
        }
        packFile(packFile);
    }

    public static JarPackFileIndex create(File packFile) {
        assert packFile != null;
        return new JarPackFileIndex(packFile);
    }

    JarPackFileIndex version(String versionCode) {
        if(versionCode == null) {
            throw new IllegalArgumentException("version not be null");
        }
        this.versionCode = versionCode;
        versionLen = this.versionCode.getBytes().length;
        return this;
    }

    JarPackFileIndex sequence(String sequence) {
        if(versionCode == null) {
            throw new IllegalArgumentException("version not be null");
        }
        this.sequence = sequence;
        sequenceLen = this.sequence.getBytes().length;
        return this;
    }

    /**
     * 获取版本号
     * @return
     */
    public String version() {
        return this.versionCode;
    }

    int versionLen() {
        return this.versionLen;
    }

    int sequenceLen() {
        return this.sequenceLen;
    }


    /**
     * 获取序列号
     * @return
     */
    public String sequence() {
        return this.sequence;
    }

    @Override
    protected int extendHeaderLength() {
        //[版本号长度(4字节)][版本号][序列号长度(4字节)][序列号]
        return 4 + versionLen + 4 + sequenceLen;
    }

    @Override
    public String type() {
        return "jar";
    }

    @Override
    protected long fileInfoLength(JarPackFileInfo info) {
        return 4 + info.name().getBytes().length + 8 + 8 + 8;
    }
}
