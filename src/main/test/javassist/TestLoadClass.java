package javassist;

import com.carl.util.JavaByteCodeUtil;
import org.junit.Test;

import java.net.URL;
import java.util.Enumeration;
import java.util.List;

import static com.carl.util.PackageUtil.getClassName;
import static com.carl.util.PackageUtil.getClassNameByFile;

/**
 * @author Carl
 * @date 2016/6/13
 * <p>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class TestLoadClass {
    @Test
    public void loadPackage() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        Enumeration<URL> urls = pool.getClassLoader().getResources("javassist");
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            String path = url.getPath();
            System.out.println("-----------------------------");
            List<String> classes = getClassNameByFile(path, null, true);
            for (String clz : classes) {
                System.out.println(clz);
            }
        }
    }

    @Test
    public void loadJar() throws Exception {
        String packageName = "com.carl";
        List<String> classNames = getClassName(packageName, true);
        if (classNames != null) {
            for (String className : classNames) {
                System.out.println(className);
            }
        }
    }

    @Test
    public void iteratorJava() throws Exception {
        String packageName = "com.carl.resale";
        //获取到所有classes
        List<String> classNames = getClassName(packageName, true);

        for(String clzName : classNames) {
            ClassPool pool = ClassPool.getDefault();
            System.out.println(pool.getClassLoader().getResource("."));
            CtClass cc = pool.get(clzName);
            JavaByteCodeUtil.get(pool).clearMethodBody(clzName);
            JavaByteCodeUtil.get(pool).clearConstructor(clzName);
            cc.writeFile("target\\test-classes");
        }
    }
}
