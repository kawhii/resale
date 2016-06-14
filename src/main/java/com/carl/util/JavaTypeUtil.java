package com.carl.util;

import javassist.CtClass;

/**
 * java类型工具
 * @author Carl
 * @date 2016/6/13
 * <p>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class JavaTypeUtil {

    /**
     * 根据javassist的类库获取它的具体类型，用于重写二进制码
     * @param ctClass
     * @return
     */
    public static String caseType(CtClass ctClass) {
        String code = "";
        if (ctClass.isPrimitive()) {
            if (ctClass == CtClass.booleanType) {
                code = "false";
            } else if (ctClass == CtClass.byteType) {
                code = "0";
            } else if (ctClass == CtClass.charType) {
                code = "0";
            } else if (ctClass == CtClass.doubleType) {
                code = "0d";
            } else if (ctClass == CtClass.floatType) {
                code = "0f";
            } else if (ctClass == CtClass.intType) {
                code = "0";
            } else if (ctClass == CtClass.longType) {
                code = "0";
            } else if (ctClass == CtClass.shortType) {
                code = "0";
            } else if (ctClass == CtClass.voidType) {
                code = null;
            }
        } else {
            code = "null";
        }

        return code;
    }
}
