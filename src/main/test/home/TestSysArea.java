package home;

import com.carl.resale.ui.bean.SysArea;
import com.carl.resale.ui.bean.SysChildrenArea;
import com.carl.resale.ui.repositories.SysAreaRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carl
 * @date 2016/3/29
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class TestSysArea extends BaseTest {
    @Autowired
    private SysAreaRepository areaRepository;

    @Test
    public void testInsert() {
        //子城市
        SysArea area1 = new SysArea();
        SysArea area2 = new SysArea();
        SysArea area3 = new SysArea();
        area1.setName("江门");
        area1.setCode("S.GD.JM");
        area1.setLevel(2);
        area1.setOrder(1);
        area2.setName("肇庆");
        area2.setCode("S.GD.ZQ");
        area2.setLevel(2);
        area2.setOrder(2);
        area3.setName("中山");
        area3.setCode("S.GD.ZS");
        area3.setLevel(2);
        area3.setOrder(3);
        //添加
        areaRepository.insert(area1);
        areaRepository.insert(area2);
        areaRepository.insert(area3);
        //父城市
        SysArea area = new SysArea();
        area.setName("广东");
        area.setCode("S.GD");
        area.setLevel(1);
        area.setOrder(1);
        SysChildrenArea childrenArea1 = new SysChildrenArea();
        childrenArea1.setId(area1.getId());
        childrenArea1.setName(area1.getName());
        childrenArea1.setOrder(area1.getOrder());
        childrenArea1.setCode(area1.getCode());
        SysChildrenArea childrenArea2 = new SysChildrenArea();
        childrenArea2.setId(area2.getId());
        childrenArea2.setName(area2.getName());
        childrenArea2.setOrder(area2.getOrder());
        childrenArea2.setCode(area2.getCode());
        SysChildrenArea childrenArea3 = new SysChildrenArea();
        childrenArea3.setId(area3.getId());
        childrenArea3.setName(area3.getName());
        childrenArea3.setOrder(area3.getOrder());
        childrenArea3.setCode(area3.getCode());
        List<SysChildrenArea> list = new ArrayList<SysChildrenArea>();
        list.add(childrenArea1);
        list.add(childrenArea2);
        list.add(childrenArea3);
        area.setChildren(list);
        //插入父节点
        areaRepository.insert(area);
    }

    @Test
    public void testSearch() {
        logger.debug(areaRepository.findLevelHighest());
    }
}
