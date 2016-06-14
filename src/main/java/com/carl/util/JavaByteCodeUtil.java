package com.carl.util;


import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtMethod;

/**
 * java字节码操作类
 *
 * @author Carl
 * @date 2016/6/13
 * <p>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class JavaByteCodeUtil {
    private ClassPool pool;
    private JavaByteCodeUtil(ClassPool pool) {
        assert pool != null;
        this.pool = pool;
    }

    /**
     * 获取单例
     * @param pool
     * @return
     */
    public synchronized static JavaByteCodeUtil get(ClassPool pool) {
        return new JavaByteCodeUtil(pool);
    }

    /**
     * 根据类名清空所有方法名字
     *
     * @param className
     * @throws Exception
     */
    public void clearMethodBody(String className) throws Exception {
        CtClass cc = pool.get(className);

        //方法体改变
        for (CtMethod cm : cc.getDeclaredMethods()) {
            clearMethodBody(className, cm.getName());
        }
    }

    /**
     * 根据方法名清空
     *
     * @param className
     * @param methodName
     * @throws Exception
     */
    public void clearMethodBody(String className, String methodName) throws Exception {
        CtClass cc = pool.get(className);
        //方法体改变
        CtMethod cm = cc.getDeclaredMethod(methodName);
        CtClass returnType = cm.getReturnType();
        String code = JavaTypeUtil.caseType(returnType);

        String bodyCode = code == null ? "{}" : "return " + code + ";";
        cm.setBody(bodyCode);

    }

    /**
     * 清空方法名，根据class
     *
     * @param clz
     * @throws Exception
     */
    public void clearMethodBody(Class<?> clz) throws Exception {
        clearMethodBody(clz.getName());
    }

    /**
     * 清空构造器
     *
     * @param className 类名
     * @throws Exception
     */
    public void clearConstructor(String className) throws Exception {
        CtClass cc = pool.get(className);
        CtConstructor[] ctConstructors = cc.getConstructors();
        //构造函数改变
        for (CtConstructor constructor : ctConstructors) {
            constructor.setBody("{}");
        }
    }

    /**
     * 清空构造器，根据class
     *
     * @param clz
     * @throws Exception
     */
    public void clearConstructor(Class<?> clz) throws Exception {
        clearConstructor(clz.getName());
    }
}
