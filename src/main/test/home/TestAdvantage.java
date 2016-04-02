package home;

import com.carl.resale.ui.bean.Advantage;
import com.carl.resale.ui.bean.SysUser;
import com.carl.resale.ui.dao.impl.AdvantageDao;
import com.carl.resale.ui.repositories.AdvantageRepository;
import com.carl.resale.ui.repositories.SysUserRepository;
import com.carl.resale.ui.service.impl.AdvantageService;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.servlet.support.RequestContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Carl
 * @date 2016/3/30
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class TestAdvantage extends BaseTest {
    @Autowired
    private AdvantageRepository advRepository;
    @Autowired
    private SysUserRepository userRepository;
    @Autowired
    private AdvantageDao advantageDao;
    @Autowired
    private AdvantageService advantageService;

    @Test
    public void testInsertAdv() {
        SysUser user = new SysUser();
        user.setContactMail("756884434@qq.com");
        user.setContactName("Carl");
        user.setContactPhone("13812312312");
        userRepository.insert(user);
        logger.debug("用户id：" + user.getId());
        Advantage advantage = new Advantage();
        advantage.setPublishUser(user);
        advantage.setBusiness("BU.MOBILE");
        advantage.setCondition("这是交易条件");
        advRepository.insert(advantage);
    }

    @Test
    public void testFind() {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("cityId", "56fa4328cfd6a51facddd94d");
        param.put("categoryId", "56fc9bb0cfd6a5199ce51405");
        logger.debug(advantageDao.getList(1, 1,param));
    }

    @Test
    public void testFindByService() {
        Sort order = new Sort(Sort.Direction.DESC, "id");
        logger.debug(advantageService.getList(1, 2, null, "56f7861612418812e8b28ec9", null, null, order));
    }
}
