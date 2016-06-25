package com.carl;

import com.sunrise.framework.core.Log;
import com.sunrise.pack.SimplePackCrypter;
import com.sunrise.pack.jar.JarPacker;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class JarReadFileAdpBuilderTest {

    @Test
    public void classLoaderTest() throws Exception {
        JarPacker packer = (JarPacker) new JarPacker().crypter(new SimplePackCrypter(SimplePackCrypter.MODE_DECRYPT));
        JarPackReadFileAdapterImp adapterImp = JarReadFileAdpBuilder
                .newJarAdapter()
                .packFile(new File("D:\\framework.sr"))
                .jarPacker(packer).build();
        SRClassLoader loader = new SRClassLoader(ClassLoader.getSystemClassLoader(), adapterImp);
        Class<?> cLass = loader.loadClass("com.sunrise.framework.module.addon.impl.DefaultSecurity");
        System.out.println(cLass);
       /* Method showM = cLass.getDeclaredMethod("show");
        Method setM = cLass.getDeclaredMethod("setTableName", String.class);
        Method setCode = cLass.getDeclaredMethod("setTableCode", String.class);
        Object obj = cLass.newInstance();
        setCode.invoke(obj,"SYS_P_USER");
        setM.invoke(obj,"SYS_P_USER 测试表");
        showM.invoke(obj);*/
    }

}