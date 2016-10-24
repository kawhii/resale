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
      //  System.out.println("111");
    }
    static{
     //   System.out.println("@!3123123");
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

    @Test
    public void main() {
        // PC WEB端
        int pc = 1 << 0;// ...0001=1

        // Android端
        int android = 1 << 1;// ...0010=2

        // iOS端
        int ios = 1 << 2;// ...0100=4

        // WindowsPhone
        int wp = 1 << 3;// ...1000=8

        //----------------校验开始-----------------
        //表示只适用于PC WEB端
        int pcAndAndroid = pc | android;
        //判断是否有android端
        System.out.println((pcAndAndroid & android) == android);// true
        //判断是否有ios
        System.out.println((pcAndAndroid & ios) == ios);// false
        //去掉android，加入ios，判断是否有ios,   pcAndAndroid & (~android) 去掉android
        System.out.println((((pcAndAndroid & (~android)) | ios) & ios) == ios);// true
        //去掉android，加入ios，判断是否有android,  false
        System.out.println((((pcAndAndroid & (~android)) | ios) & android) == android);// false

        //--------------
        // android/ios/win phone
        int aiw = android | ios | wp;
        //判断是否有android 并且有win phone
        System.out.println((aiw & (android | wp)) == (android | wp));// true
        //判断是否有android 并且有pc
        System.out.println((aiw & (android | pc)) == (android | pc));// false
    }
}
