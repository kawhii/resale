package home;

import com.carl.resale.ui.dao.impl.CategoriesDao;
import com.carl.resale.ui.repositories.CategoriesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

/**
 * @author Carl
 * @date 2016/3/19
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:context/servlet-context.xml", "classpath:context/spring-context.xml"})
public class TestBrandDao {
    @Autowired
    private CategoriesDao categoriesDao;
    @Qualifier("categoriesRepository")
    @Autowired
    private CategoriesRepository categoriesRepository;


    @Test
    public void testGetHomePageBrand() {
        Assert.isTrue(categoriesDao.getHomePageCategories(10).size() == 10);
    }

    @Test
    public void testCategoryRepository() {
        System.out.println(categoriesRepository.findByHome("工作"));
    }
}
