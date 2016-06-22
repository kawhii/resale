package com.carl;

import com.sunrise.pack.IPackCrypter;
import com.sunrise.pack.jar.JarPacker;

import java.io.File;

/**
 * 适配器构建
 *
 * @author Carl
 * @date 2016/6/16
 * <p>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class JarReadFileAdpBuilder {
    private JarPackReadFileAdapterImp adapter;

    private JarReadFileAdpBuilder() {
        adapter = new JarPackReadFileAdapterImp();
    }

    public static JarReadFileAdpBuilder newJarAdapter() {
        return new JarReadFileAdpBuilder();
    }

    /**
     * 打包文件
     * @param file
     * @return
     */
    public JarReadFileAdpBuilder packFile(File file) {
        adapter = adapter.packFile(file);
        return this;
    }

    /**
     * jar包处理器
     * @param jarPacker
     * @return
     */
    public JarReadFileAdpBuilder jarPacker(JarPacker jarPacker) {
        adapter = adapter.packer(jarPacker);
        return this;
    }

    /**
     * 构建
     * @return
     * @throws Exception
     */
    public JarPackReadFileAdapterImp build() throws Exception {
        return adapter.build();
    }
}
