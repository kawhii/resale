package classloader;

import com.carl.resale.ui.bean.Brand;
import com.carl.resale.ui.bean.SysUser;
import com.carl.task.ClearJavaBodyTask;
import com.carl.util.MyClassLoader;
import org.junit.Test;

/**
 * @author Carl
 * @date 2016/6/16
 * <p>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class ChangeLoaderTest {

    @Test
    public void testLoad() throws Exception {
        // Save class loader so that we can restore later.


        ClassLoader oldLoader = Thread.currentThread().getContextClassLoader();

        MyClassLoader newLoader = new MyClassLoader();
        try {
            // Set new classloader.
            System.setProperty("-D java.system.class.loader", MyClassLoader.class.getName());
            System.out.println(ClassLoader.getSystemClassLoader());

            // My class.
            TestBean bean = new TestBean();
            bean.setName("n");
            System.out.println(bean);
            System.out.println(bean.getName());
        } finally {
            // Restore.
            Thread.currentThread().setContextClassLoader(oldLoader);
        }
    }

    private class TestBean {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
