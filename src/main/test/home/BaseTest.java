package home;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Carl
 * @date 2016/3/27
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:context/servlet-context.xml", "classpath:context/spring-context.xml"})
public abstract class BaseTest {
}
