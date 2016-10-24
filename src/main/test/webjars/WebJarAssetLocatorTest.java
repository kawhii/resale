package webjars;

import org.junit.Before;
import org.junit.Test;
import org.webjars.WebJarAssetLocator;

/**
 * @author Carl
 * @date 2016/10/19
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class WebJarAssetLocatorTest {
    WebJarAssetLocator webJarAssetLocator;
    @Before
    public void setUp() throws Exception {
        webJarAssetLocator = new WebJarAssetLocator();

    }

    @Test
    public void loadJs() throws Exception {
        String path = webJarAssetLocator.getFullPath("jquery.min.js");
        System.out.println(webJarAssetLocator.getWebJars());
        System.out.println(path);
    }
}
