package com.carl.resale.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串参数匹配器
 * @author Carl
 * @date 2016/4/11
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class StringMatcher extends StringMatcherSupport{
    //默认监听器
    private StringMatcherListener listener = new StringMatcherListener() {
        @Override
        public void onScan(String matcher, String key, String value, Event event) {
           //nothing do
        }
    };

    public StringMatcher(String input) {
        super(input);
    }

    /**
     * 重写父类
     * @param params
     * @return
     */
    public String resolve(Map<String, String> params) {
        return super.resolve(params, listener);
    }


    public static void main(String[] args) {
        String input = "我叫${name},我非常爱${add},你呢${name}？";
        StringMatcher matcher = new StringMatcher(input);
        //matcher.setPrefix("");
        Map<String, String> param = new HashMap<String, String>();
        param.put("name","carl");
        param.put("add","123");
        System.out.println(matcher.resolve(param));
        //处理结果
        System.out.println(matcher.getHandleStatistics());
    }
}
