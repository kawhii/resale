package shiro;

import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.junit.Test;

/**
 * @author Carl
 * @date 2016/4/27
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class FactoryTest {
    @Test
    public void testCreateInstance() throws InterruptedException {
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory();
        System.out.println(factory.getInstance());
        Thread.sleep(5000);
        IniSecurityManagerFactory factory2 = new IniSecurityManagerFactory();
        System.out.println(factory2.getInstance());
    }
}
