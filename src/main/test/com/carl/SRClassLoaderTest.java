package com.carl;

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
        Class c = Class.forName("com.carl.StaticTest");

        c.newInstance();
        Class c1 = Class.forName("com.carl.StaticTest");
        c1.newInstance();
    }
}