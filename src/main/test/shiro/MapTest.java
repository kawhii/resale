package shiro;

import org.apache.shiro.web.filter.mgt.NamedFilterList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Carl
 * @date 2016/4/29
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class MapTest {
    Map<String, Map<String, String>> test = new HashMap<String, Map<String, String>>();

    public  Map<String, String> ensureMap(String key) {
        Map<String, String> m = test.get(key);
        if(m == null) {
            m = new HashMap<String, String>();
            test.put(key, m);
        }
        return m;
    }

    public static void main(String[] args) {
        MapTest mapTest = new MapTest();
        Map<String, String> k = mapTest.ensureMap("myKey");
        k.put("name", "value");
        System.out.println(mapTest.test);
    }
}
