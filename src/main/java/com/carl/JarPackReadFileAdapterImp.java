package com.carl;

import com.sunrise.pack.jar.JarPackFileIndex;
import com.sunrise.pack.jar.JarPackFileInfo;
import com.sunrise.pack.jar.JarPacker;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * jar包打包读取适配器实现
 * @author Carl
 * @date 2016/6/16
 * <p>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class JarPackReadFileAdapterImp implements SRClassLoader.JarPackReadFileAdapter {
    private Map<String, JarPackFileInfo> sclClassName = new HashMap<String, JarPackFileInfo>();
    private JarPacker packer;
    //解码
   // private IPackCrypter decrypt = new SimplePackCrypter(SimplePackCrypter.MODE_DECRYPT);
    private File packFile;

    JarPackReadFileAdapterImp() {

    }

    JarPackReadFileAdapterImp packer(JarPacker packer) {
        this.packer = packer;
        return this;
    }

    JarPackReadFileAdapterImp packFile(File packFile) {
        this.packFile = packFile;
        return this;
    }

    @Override
    public byte[] read(String clzName) throws IOException {
        return packer.readFileContent(sclClassName.get(clzName));
    }

    @Override
    public boolean exists(String clzName) {
        return sclClassName.containsKey(clzName);
    }

    JarPackReadFileAdapterImp build() throws IOException {
        if (packer == null || packFile == null || !packFile.exists()) {
            throw new IllegalArgumentException("argument is null or the pack file is not exists or pack file is not a file");
        }
        JarPackFileIndex index = packer.readIndex(packFile);
        for (JarPackFileInfo info : index.files()) {
            String name = info.name();
            name = name.endsWith(".class") ? name.substring(0, name.length() - 6): name;
            sclClassName.put(name, info);
        }
        return this;
    }
}
