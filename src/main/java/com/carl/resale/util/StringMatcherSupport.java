package com.carl.resale.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串匹配器父类
 * @author Carl
 * @date 2016/4/11
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public abstract class StringMatcherSupport {
    private final String DEFAULT_PREFIX = "\\$";
    private final String INCLUDE_START = "\\{";
    private final String INCLUDE_END = "\\}";

    //值匹配
    private final String INCLUDE_VALUE = "\\w+";

    //前缀
    private String prefix = DEFAULT_PREFIX;
    //参数开始
    private String start = INCLUDE_START;

    //参数结束
    private String end = INCLUDE_END;

    //匹配值
    private String includeValue = INCLUDE_VALUE;

    private Map<String, Integer> handleStatistics = new HashMap<String, Integer>();

    //输入值
    private String inputStr;

    public StringMatcherSupport(String input) {
        this.inputStr = input;
    }

    public String getInputStr() {
        return inputStr;
    }

    /**
     * 构建表达式
     * @return
     */
    protected Pattern buildPattern() {
        String p = "(" + prefix + start + ")" + "(" + includeValue + ")(" + end + ")";
        return Pattern.compile(p, Pattern.CASE_INSENSITIVE);
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getIncludeValue() {
        return includeValue;
    }

    public void setIncludeValue(String includeValue) {
        this.includeValue = includeValue;
    }

    /**
     * 解决匹配值
     * @param params 根据key来获取value替换字符串中的值
     * @param listener 监听器
     * @return
     */
    public String resolve(Map<String, String> params, StringMatcherListener listener) {
        String val = this.inputStr;
        if(params == null) {
            return val;
        }
        Pattern pattern = buildPattern();
        Matcher matcher = pattern.matcher(this.inputStr);
        while (matcher.find()) {
            Event event = Event.HANDLE;
            String g = matcher.group(2);
            String key = getGroupMatcherStr(g);
            String param = params.get(g);
            //计算
            Integer handleCount = statistics(g);
            //为空不处理,处理过不处理
            if(param != null && handleCount == 1) {
                val = val.replaceAll(key, param);
            } else {
                event = Event.IGNORE;
            }
            listener.onScan(g, key, param, event);
        }
        return val;
    }

    /**
     * 对key进行加值
     * @param groupName
     * @return 处理次数
     */
    private Integer statistics(String groupName) {
        Integer count = handleStatistics.get(groupName);
        Integer val;
        if(count == null || count == 0) {
            val = 1;
        } else {
            val = ++count;
        }
        handleStatistics.put(groupName, val);
        return val;
    }

    /**
     * 根据值来获取匹配中的字符串
     * @param key 匹配出结果key
     * @return
     */
    protected String getGroupMatcherStr(String key) {
        return prefix + start + key + end;
    }

    public Map<String, Integer> getHandleStatistics() {
        return handleStatistics;
    }

    /**
     * 扫描监听器
     */
    public static interface StringMatcherListener {

        /**
         * 扫描返回
         * @param matcher 进行字符串的匹配
         * @param key 全量匹配
         * @param value 从参数中获取值
         * @param event 扫描处理事件
         */
        public void onScan(String matcher, String key, String value, Event event);
    }

    //处理事件
    public static enum Event {
        //处理
        HANDLE,
        //忽略
        IGNORE
    }
}
