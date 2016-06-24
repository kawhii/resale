package com.carl;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sunrise.pack.DoNothingPackCrypter;
import com.sunrise.pack.SimplePackCrypter;
import com.sunrise.pack.jar.JarPacker;
import javassist.ClassPool;
import javassist.CtClass;

import java.io.File;
import java.io.InputStream;

public class SRClassLoaderTest {

    //  @Test
    public void instance() {
        SRClassLoader SRClassLoader = new SRClassLoader(null, null);
        System.setProperty("java.system.class.loader", SRClassLoader.class.getName());
        System.out.println(ClassLoader.getSystemClassLoader());
    }

    /*public static void main(String[] args) {
        Class thsClz = SRClassLoaderTest.class;
        System.setProperty("java.system.class.loader", SRClassLoader.class.getName());
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader.getClass().getName() + "---");
        loader = new SRClassLoader(loader, null);
        System.out.println(loader.getClass().getName() + "--");
    }*/

    public static void main(String[] args) throws Exception {
        JarPacker packer = (JarPacker) new JarPacker().crypter(new DoNothingPackCrypter());
        JarPackReadFileAdapterImp adapterImp = JarReadFileAdpBuilder
                .newJarAdapter()
                .packFile(new File("D:\\framework.sr"))
                .jarPacker(packer).build();
        SRClassLoader loader = new SRClassLoader(Thread.currentThread().getContextClassLoader(), adapterImp);
        loader.loadClass("com.sunrise.framework.module.deploy.cmd.CmdFileDeployer").newInstance();
        ClassPool classPool = ClassPool.getDefault();
        InputStream i = new ByteInputStream();
        //loader.loadClass("com.carl.StaticTest").newInstance();
    }
}