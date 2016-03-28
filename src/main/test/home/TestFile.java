package home;

import com.carl.resale.ui.bean.SysFile;
import com.carl.resale.ui.repositories.SysFileRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 测试文件
 * @author Carl
 * @date 2016/3/28
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */

public class TestFile extends BaseTest {
    @Autowired
    private SysFileRepository fileRepository;

    @Test
    public void testInsert() {
        SysFile file = new SysFile();
        file.setName("a.jpg");
        file.setBusiness("test");
        file.setType("type");
        file.setPath("type/a.jpg");
        file.setSize(100L);
        file.setStatus(0);
        file.setCreateTime(new Date());
        file.setNote("这是图片");
        fileRepository.save(file);
        SysFile fFile =  fileRepository.findOne(file.getId());
        Assert.assertTrue(fFile.getId().toString().equals(file.getId().toString()));
       // fileRepository.delete(file.getId());
    }
}
