package home;

import com.carl.resale.ui.bean.Category;
import com.carl.resale.ui.bean.QCategory;
import com.carl.resale.ui.bean.SpecificType;
import com.carl.resale.ui.bean.State;
import com.carl.resale.ui.repositories.CategoryRepository;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carl
 * @date 2016/3/24
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:context/servlet-context.xml", "classpath:context/spring-context.xml"})
public class TestCategory {
    @Qualifier("categoryRepository")
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testSave() {
        Category category = new Category();
        category.setBusiness("businessId");
        category.setCode("CU.MOBILE");
        category.setName("手机");
        category.setCssName("SR_table");
        category.setOrder(1);
        State state = new State();
        state.setCode("C");
        state.setNote("正常");
        category.setState(state);
        category.setGoodsCount(100);
        category.setImageId(new ObjectId());
        List<SpecificType> specTypes = new ArrayList<SpecificType>();
        SpecificType st1 = new SpecificType();
        st1.setCode("s1");
        st1.setGoodsCount(50);
        st1.setOrder(1);
        SpecificType st2 = new SpecificType();
        st2.setCode("s2");
        st2.setGoodsCount(50);
        st2.setOrder(2);
        specTypes.add(st1);
        specTypes.add(st2);
        category.setSpecTypes(specTypes);
        categoryRepository.save(category);
        Assert.assertTrue(categoryRepository.exists(category.getId()));
    }

    @Test
    public void testQueryDsl() {
//        categoryRepository.findAll(QCategory.category);
    }
}
