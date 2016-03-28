package com.carl.resale.core;

/**
 * 常量类
 *
 * @author Carl
 * @date 2016/3/28
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class Constants {
    private static String WEB_ROOT;
    private static String ENCODING;
    private static String SYSTEM_CODE;

    public Constants() {
    }

    public static String getWebRoot() {
        return WEB_ROOT;
    }

    static void setWebRoot(String root) {
        WEB_ROOT = root == null ? null : root.replace('\\', '/');
    }

    public static String getEncoding() {
        return ENCODING;
    }

    static void setEncoding(String encoding) {
        ENCODING = encoding;
    }

    public void setSystemCode(String code) {
        SYSTEM_CODE = code;
    }

    public String getSystemCode() {
        return SYSTEM_CODE;
    }
}
