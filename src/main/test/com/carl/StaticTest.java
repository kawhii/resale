package com.carl;

import javassist.*;
import org.junit.Test;

/**
 * @author Carl
 * @date 2016/6/21
 * <p>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class StaticTest {
    /*static {
        System.out.println("--------------");
        try {
            Class.forName("com.sunrise.framework.module.deploy.cmd.CmdFileDeployer").newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }*/
    {
        System.out.println("111");
    }
    static{
        System.out.println("@!3123123");
    }

    @Test
    public void test() throws NotFoundException {
       /* String lineseparator = System.getProperty("os.name");
        CtClass c = null;
        c.defrost();
        c.getClassInitializer().instrument();
        System.out.println(lineseparator);*/
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get("com.carl.StaticTest");
        for(CtMethod cm : ctClass.getDeclaredMethods()) {
        }
    }
}
