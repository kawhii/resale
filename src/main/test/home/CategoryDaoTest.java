package home;

import com.carl.resale.ui.dao.impl.CategoryDao;
import com.carl.resale.ui.service.impl.CategoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Carl
 * @date 2016/3/27
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class CategoryDaoTest extends BaseTest {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private CategoryService categoryService;

    @Test
    public void testHomeDao() {
        System.out.println(categoryDao.getHomePageCategory(10));
    }

    @Test
    public void testHomeService() {
        System.out.println(categoryService.getHomePageCategory(1));
    }
}
