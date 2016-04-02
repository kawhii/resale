package home;

import com.carl.resale.ui.repositories.HotAdvantageRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author Carl
 * @date 2016/4/2
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class HotAdvantageTest extends BaseTest {
    @Autowired
    @Qualifier("hotAdvantageRepository")
    private HotAdvantageRepository hotAdvantageRepository;

    @Test
    public void queryTest() {
        logger.debug(hotAdvantageRepository.getHomePageHotAdv());
    }
}
