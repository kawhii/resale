package com.carl;

import java.io.IOException;

/**
 * 自定义的加载器,用于加载打包后的文件，进行读取
 *
 * @author Carl
 * @date 2016/6/16
 * <p>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class SRClassLoader extends ClassLoader {
    private ClassLoader parent;
    private JarPackReadFileAdapter adapter;

    public SRClassLoader(ClassLoader parent, JarPackReadFileAdapter adapter) {
        super(parent);
        if (parent == null || adapter == null) {
            throw new IllegalArgumentException("argument is not be null");
        }

        this.parent = parent;
        this.adapter = adapter;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        //判断是否在加密包中存在该class，若存在，读取并且进行获取
        if (adapter.exists(name)) {
            byte[] clzByte;
            try {
                clzByte = adapter.read(name);
            } catch (IOException e) {
                throw new ClassNotFoundException("", e);
            }
            if (clzByte != null) {
                return defineClass(name, clzByte, 0, clzByte.length);
            }
        }
        return loadClass(name, false);
    }

    /**
     * 读取class适配器接口
     */
    static interface JarPackReadFileAdapter {

        /**
         * 根据类名读取字节码
         *
         * @param clzName
         * @return
         */
        byte[] read(String clzName) throws IOException;

        /**
         * 是否存在该类名的加密处理
         *
         * @param clzName
         * @return
         */
        boolean exists(String clzName);
    }
}
