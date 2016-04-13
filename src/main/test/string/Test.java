package string;

import com.carl.resale.util.StringMatcher;
import com.carl.resale.util.StringMatcherSupport;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Carl
 * @date 2016/4/11
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class Test {
    public static void main(String[] args) {
        String input = "我叫${name},我非常爱${add},你呢${name}？,${a},我今天出差了";
        StringMatcher matcher = new StringMatcher(input);
        //matcher.setPrefix("");
        Map<String, String> param = new HashMap<String, String>();
        param.put("name","carl");
        param.put("add","123");
        System.out.println(matcher.resolve(param, new StringMatcherSupport.StringMatcherListener() {
            @Override
            public void onScan(String matcher, String key, String value, StringMatcherSupport.Event event) {
                System.out.println(matcher);
                System.out.println(key);
                System.out.println(value);
                System.out.println(event);
                System.out.println("--------------------");
            }
        }));
        //处理结果
        System.out.println(matcher.getHandleStatistics());
    }
}
