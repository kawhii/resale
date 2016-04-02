package home;

import com.carl.resale.ui.bean.Category;
import com.carl.resale.ui.bean.QCategory;
import com.carl.resale.ui.bean.SpecificType;
import com.carl.resale.ui.bean.State;
import com.carl.resale.ui.repositories.CategoryRepository;
import com.carl.resale.ui.repositories.SpecificTypeRepository;
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

    @Qualifier("specificTypeRepository")
    @Autowired
    private SpecificTypeRepository specificTypeRepository;

    @Test
    public void testSave() {
        Category category = new Category();
        category.setBusiness("MOTORCYCLE");
        category.setCode("CU.MOTORCYCLE");
        category.setName("自行车");
        category.setCssName("motorcycle");
        category.setOrder(2);
        State state = new State();
        state.setCode("C");
        state.setNote("正常");
        category.setState(state);
        category.setGoodsCount(100);
        category.setImageId(new ObjectId());
        List<SpecificType> specTypes = new ArrayList<SpecificType>();
        SpecificType st1 = new SpecificType();
        st1.setCode("s1");
        st1.setName("摩托车");
        st1.setGoodsCount(50);
        st1.setOrder(1);
        SpecificType st2 = new SpecificType();
        st2.setCode("s2");
        st2.setName("独轮车");
        st2.setGoodsCount(50);
        st2.setOrder(2);
        specificTypeRepository.insert(st1);
        specificTypeRepository.insert(st2);
        specTypes.add(st1);
        specTypes.add(st2);
        category.setSpecTypes(specTypes);

        Category.ShowType showType1 = new Category.ShowType();
        showType1.setId(new ObjectId());
        showType1.setTitle("全部照片");
        showType1.setOrder(1);
        Category.ShowType showType2 = new Category.ShowType();
        showType2.setId(new ObjectId());
        showType2.setTitle("公司内部");
        showType2.setOrder(2);
        List<Category.ShowType> types = new ArrayList<Category.ShowType>();
        types.add(showType1);
        types.add(showType2);
        category.setShowTypes(types);
        categoryRepository.save(category);
        Assert.assertTrue(categoryRepository.exists(category.getId()));
    }

    @Test
    public void testQueryDsl() {
//        categoryRepository.findAll(QCategory.category);
    }
}
