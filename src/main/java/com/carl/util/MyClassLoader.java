package com.carl.util;

/**
 * @author Carl
 * @date 2016/6/16
 * <p>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class MyClassLoader extends ClassLoader {
    public MyClassLoader() {
        super();
    }

    @Override
    public synchronized Class<?> loadClass(String name)
            throws ClassNotFoundException {
        System.out.println("Load: " + name);

        return super.loadClass(name);
    }
}
