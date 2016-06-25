/**
 * @(#)StringUtil.java 2007-6-19
 * CopyRight 2007. All rights reseved
 */
package com.sunrise.foundation.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author kinz
 * @version 1.0 2007-6-19
 * @since JDK1.4
 */
public class StringUtil {

    /**
     * 生成字符串类型：大写英文字母
     */
    public static final int GEN_UPPERCASE = 0;
    /**
     * 生成字符串类型：小写英文字母
     */
    public static final int GEN_LOWERCASE = 1;
    /**
     * 生成字符串类型：汉字
     */
    public static final int GEN_CHINESE = 2;
    /**
     * 生成字符串类型：数字
     */
    public static final int GEN_NUMBER = 3;
    private static Log log = LogFactory.getLog(StringUtil.class);

    public static boolean isNull(String str) {
        if (str == null)
            return true;
        if (str.trim().length() == 0)
            return true;
        return false;
    }

    /**
     * 将一个对象转换成一个字符串
     * <p/>
     * 如果对象是一个数组，则返回以半角逗号隔开的字符串
     *
     * @param obj
     * @return
     */
    public static String valueOf(Object obj) {
        if (obj == null) {
            //return null;
            return "";
        } else if (obj instanceof String) {
            return (String) obj;
        } else if (obj instanceof Object[]) {
            return join((Object[]) obj, ",");
        } else if (obj instanceof String[]) {
            return join((String[]) obj, ",");
        } else if (obj instanceof double[]) {
            return join((double[]) obj, ",");
        } else if (obj instanceof long[]) {
            return join((long[]) obj, ",");
        } else if (obj instanceof float[]) {
            return join((float[]) obj, ",");
        } else if (obj instanceof int[]) {
            return join((int[]) obj, ",");
        } else if (obj instanceof short[]) {
            return join((short[]) obj, ",");
        } else if (obj instanceof byte[]) {
            return join((byte[]) obj, ",");
        }
        return String.valueOf(obj);
    }

    public static Integer getInt(String str) {
        try {
            return Integer.parseInt(str.trim());
        } catch (Exception ex) {
            return null;
        }
    }

    public static Integer[] getIntArray(String str, String spliter) {
        if (isNull(str)) {
            return new Integer[0];
        } else {
            String[] strs = str.split(spliter);
            List<Integer> tmp = new ArrayList<Integer>();
            for (int i = 0; i < strs.length; i++) {
                Integer val = getInt(strs[i]);
                if (val != null)
                    tmp.add(val);
            }
            return tmp.toArray(new Integer[tmp.size()]);
        }
    }

    public static Long getLong(String str) {
        try {
            return Long.parseLong(str.trim());
        } catch (Exception ex) {
            return null;
        }
    }

    public static Long[] getLongArray(String str, String spliter) {
        if (isNull(str)) {
            return new Long[0];
        } else {
            String[] strs = str.split(spliter);
            List<Long> tmp = new ArrayList<Long>();
            for (int i = 0; i < strs.length; i++) {
                Long val = getLong(strs[i]);
                if (val != null)
                    tmp.add(val);
            }
            return tmp.toArray(new Long[tmp.size()]);
        }
    }

    public static Boolean getBoolean(String str) {
        try {
            return Boolean.parseBoolean(str.trim());
        } catch (Exception ex) {
            return null;
        }
    }

    public static Boolean[] getBooleanArray(String str, String spliter) {
        if (isNull(str)) {
            return new Boolean[0];
        } else {
            String[] strs = str.split(spliter);
            List<Boolean> tmp = new ArrayList<Boolean>();
            for (int i = 0; i < strs.length; i++) {
                Boolean val = getBoolean(strs[i]);
                if (val != null)
                    tmp.add(val);
            }
            return tmp.toArray(new Boolean[tmp.size()]);
        }
    }

    public static Float getFloat(String str) {
        try {
            return Float.parseFloat(str.trim());
        } catch (Exception ex) {
            return null;
        }
    }

    public static Float[] getFloatArray(String str, String spliter) {
        if (isNull(str)) {
            return new Float[0];
        } else {
            String[] strs = str.split(spliter);
            List<Float> tmp = new ArrayList<Float>();
            for (int i = 0; i < strs.length; i++) {
                Float val = getFloat(strs[i]);
                if (val != null)
                    tmp.add(val);
            }
            return tmp.toArray(new Float[tmp.size()]);
        }
    }

    public static Double getDouble(String str) {
        try {
            return Double.parseDouble(str.trim());
        } catch (Exception ex) {
            return null;
        }
    }

    public static Double[] getDouble(String str, String spliter) {
        if (isNull(str)) {
            return new Double[0];
        } else {
            String[] strs = str.split(spliter);
            List<Double> tmp = new ArrayList<Double>();
            for (int i = 0; i < strs.length; i++) {
                Double val = getDouble(strs[i]);
                if (val != null)
                    tmp.add(val);
            }
            return tmp.toArray(new Double[tmp.size()]);
        }
    }

    public static Date getDate(String str, String format) {
        try {
            return new SimpleDateFormat(format).parse(str.trim());
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 转换成UTF8编码
     *
     * @param s
     * @return
     */
    public static String toUtf8String(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 0 && c <= '\377') {
                sb.append(c);
            } else {
                byte b[];
                try {
                    b = Character.toString(c).getBytes("utf-8");
                } catch (Exception ex) {
                    log.error(ex);
                    b = new byte[0];
                }
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0) {
                        k += 256;
                    }
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }

        return sb.toString();
    }

    /**
     * 转换字符串的字符集
     *
     * @param oldString  要转换的字符串
     * @param oldCharset 字符串本来的字符集，可以不指定（如果不指定将使用系统默认字符集），不指定传入null或者空字符串
     * @param newCharset 要转换成的字符集
     * @return 转换字符集后的字符串
     */
    public static String changeEncoding(String oldString, String oldCharset, String newCharset) {
        //字符串为空，不需要转换，返回原字符串
        if (isNull(oldString)) {
            return oldString;
        }
        //没有指定要转换的字符集，返回原字符串
        if (isNull(newCharset)) {
            return oldString;
        }
        if (oldCharset == null)
            oldCharset = null;
        //要转换的字符集和本来的字符集一样，返回原字符串
        if (newCharset.trim().equalsIgnoreCase(oldCharset.trim())) {
            return oldString;
        }
        try {
            //如果没有指定本来的字符集，则不忽略本来字符集的处理
            if (isNull(oldCharset)) {
                return new String(oldString.getBytes(), newCharset);
            } else {
                return new String(oldString.getBytes(oldCharset), newCharset);
            }
        } catch (UnsupportedEncodingException uee) {
            log.error("由于系统不支持编码[" + oldCharset + "]或者[" + newCharset + "]，因此未能进行转换，直接返回原字符串", uee);
            return oldString;
        }
    }

    /**
     * 匹配pattern，使用正则表达式
     *
     * @param str
     * @param patterns
     * @return
     */
    public static boolean matchPattern(String str, String[] patterns) {
        if (str == null || patterns == null)
            return false;
        for (String p : patterns) {
            if (matchPattern(str, p))
                return true;
        }
        return false;
    }

    /**
     * 正则表达式匹配判断
     *
     * @param str
     * @param pattern
     * @return
     */
    public static boolean matchPattern(String str, String pattern) {
//		log.debug("Matching [" + str + "  -->  " + pattern + "]");
        return (pattern == null) ? false : Pattern.matches(pattern, str);
    }

    /**
     * 将指定的字符串转换为unicode表示的字符串，而且可以将特定的字符转换为mask指定的字符串
     *
     * @param strText
     * @param mask
     * @return
     * @throws Exception
     */
    public static String toUnicode(String strText, Map<Integer, String> mask) throws Exception {
        char c;
        int intAsc;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strText.length(); i++) {
            c = strText.charAt(i);
            intAsc = (int) c;
            if (mask != null && mask.containsKey(intAsc))
                sb.append(mask.get(intAsc));
            else if (intAsc > 128) {
                sb.append("\\u" + Integer.toHexString(intAsc));
            } else {
                sb.append(c);
            }
        }
        //return strRet;
        return sb.toString();
    }

    /**
     * 将一个字符串转换成一个Unicode字符串
     *
     * @param strText
     * @return
     * @throws Exception
     */
    public static String toUnicode(String strText) throws Exception {
        return toUnicode(strText, null);
    }

    public static String random(int length, int... types) {
        return generateRandomString(types, length);
    }

    /**
     * 随机生成指定长度的字符串
     *
     * @param stringTypes 字符串的类型，可包含多种类型
     * @param length
     * @return
     */
    public static String generateRandomString(int[] stringTypes, int length) {
        int[] startChars = new int[100];
        int[] endChars = new int[100];
        int actLength = 0;

        for (int i = 0; i < stringTypes.length; i++) {
            if (actLength > startChars.length)
                break;
            if (stringTypes[i] == GEN_CHINESE) {
                startChars[actLength] = 0x4E00;
                endChars[actLength] = 0x9FB0;
                //				startChars[actLength] = 0xB0A1;
                //				endChars[actLength] = 0xF7FE;
                actLength++;
            } else if (stringTypes[i] == GEN_LOWERCASE) {
                //				startChars[actLength] = 97;
                //				endChars[actLength] = 122;
                startChars[actLength] = 'a';
                endChars[actLength] = 'z';
                actLength++;
            } else if (stringTypes[i] == GEN_UPPERCASE) {
                //				startChars[actLength] = 65;
                //				endChars[actLength] = 90;
                startChars[actLength] = 'A';
                endChars[actLength] = 'Z';
                actLength++;
            } else if (stringTypes[i] == GEN_NUMBER) {
                startChars[actLength] = '0';
                endChars[actLength] = '9';
                actLength++;
            }
        }
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; i++) {
            int idx = Math.abs(random.nextInt()) % actLength;
            int startChar = startChars[idx];
            int endChar = endChars[idx];
            char randChar = (char) (Math.abs(random.nextInt()) % (endChar - startChar) + startChar);
            //			System.out.println(randChar);
            sb.append(randChar);
        }

        return sb.toString();
    }

    public static boolean isEquals(String str1, String str2, boolean trim) {
        str1 = trim(str1);
        str2 = trim(str2);

        if (str1 == null)
            return str2 == null || (str2.length() == 0 && trim);
        if (str1.length() == 0) {
            if (trim)
                return isNull(str2);
            else
                return str2 != null && str2.length() == 0;
        } else {
            if (trim) {
                return str1.equals(str2);
            } else {
                return str1.equals(str2);
            }
        }
    }

    public static String trim(String str) {
        if (str == null)
            return str;
        else
            return str.trim();
    }

    /**
     * 将毫秒格式的时间转换成"日时分秒"的格式字符串 如：60000毫秒转换成 1分0秒；3600000毫秒转换成 1小时0分0秒
     *
     * @param time
     * @return
     */
    public static String toTimeStr(long time, boolean showZero) {
        // 先变成秒
        long seconds = time / 1000;
        int minutes = 0;
        int hours = 0;
        int days = 0;
        // 先计算日，一日有24*60*60=86400秒，用seconds整除这个数
        days = (int) seconds / 86400;
        // 剩余的时间
        seconds = seconds % 86400;
        // 计算小时数
        hours = (int) seconds / 3600;
        seconds = seconds % 3600;
        minutes = (int) seconds / 60;
        seconds = seconds % 60;
        String str = "";
        if (days > 0) {
            str = days
                    + "天"
                    + (hours == 0 && !showZero ? "" : hours + "小时")
                    + (minutes == 0 && !showZero ? "" : minutes + "分")
                    + (seconds == 0 && !showZero ? "" : seconds + "秒");
        } else if (hours > 0) {
            str = hours
                    + "小时"
                    + (minutes == 0 && !showZero ? "" : minutes + "分")
                    + (seconds == 0 && !showZero ? "" : seconds + "秒");
        } else if (minutes > 0) {
            str = minutes + "分" + (seconds == 0 && !showZero ? "" : seconds + "秒");
        } else {
            str = seconds + "秒";
        }
        return str;
    }

    /**
     * 生成一个GUID
     *
     * @return
     */
    public static String generateGUID() {
        UUID uid = UUID.randomUUID();

        return uid.toString().replaceAll("-", "").toUpperCase();
    }

    /**
     * 将字节数组的所有元素使用指定的字符连接起来
     *
     * @param arr
     * @param spliter
     * @return
     */
    public static String join(byte[] arr, String spliter) {
        StringBuilder sb = new StringBuilder();
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (i > 0)
                    sb.append(spliter);
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 将short数组的所有元素使用指定的字符连接起来
     *
     * @param arr
     * @param spliter
     * @return
     */
    public static String join(short[] arr, String spliter) {
        StringBuilder sb = new StringBuilder();
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (i > 0)
                    sb.append(spliter);
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 将double数组的所有元素使用指定的字符连接起来
     *
     * @param arr
     * @param spliter
     * @return
     */
    public static String join(double[] arr, String spliter) {
        StringBuilder sb = new StringBuilder();
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (i > 0)
                    sb.append(spliter);
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 将float数组的所有元素使用指定的字符连接起来
     *
     * @param arr
     * @param spliter
     * @return
     */
    public static String join(float[] arr, String spliter) {
        StringBuilder sb = new StringBuilder();
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (i > 0)
                    sb.append(spliter);
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 将int节数组的所有元素使用指定的字符连接起来
     *
     * @param arr
     * @param spliter
     * @return
     */
    public static String join(int[] arr, String spliter) {
        StringBuilder sb = new StringBuilder();
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (i > 0)
                    sb.append(spliter);
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 将long数组的所有元素使用指定的字符连接起来
     *
     * @param arr
     * @param spliter
     * @return
     */
    public static String join(long[] arr, String spliter) {
        StringBuilder sb = new StringBuilder();
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (i > 0)
                    sb.append(spliter);
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 将字符串数组的所有元素使用指定的字符连接起来
     *
     * @param arr
     * @param spliter
     * @return
     */
    public static String join(String[] arr, String spliter) {
        StringBuilder sb = new StringBuilder();
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (i > 0)
                    sb.append(spliter);
                sb.append(arr[i] == null ? "" : arr[i].trim());
            }
        }
        return sb.toString();
    }

    /**
     * 将对象数组的所有元素使用指定的字符连接起来
     *
     * @param arr
     * @param spliter
     * @return
     */
    public static String join(Object[] arr, String spliter) {
        StringBuilder sb = new StringBuilder();
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (i > 0)
                    sb.append(spliter);
                String val = valueOf(arr[i]);
                sb.append(val == null ? "" : val.trim());
            }
        }
        return sb.toString();
    }

    /**
     * <pre>
     * 获取字符串的字节数
     * </pre>
     *
     * @param str
     * @return
     */
    public static int length(String str) {
        //long start = System.currentTimeMillis();
        if (str == null)
            return 0;
        int length = 0;
        char[] chars = str.toCharArray();

        for (char c : chars) {
            if (c >= 128)
                length += 2;
            else
                length += 1;
        }

        //                length = str.getBytes().length;
        //long end = System.currentTimeMillis();

        //System.out.println("Time:" + (end - start) + "ms");
        return length;
    }

    public static String escape(String src, String pre) {
        if (src == null)
            return null;
        int i;
        char j;
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length() * 6);
        for (i = 0; i < src.length(); i++) {
            j = src.charAt(i);
            if (Character.isDigit(j) || Character.isLowerCase(j) || Character.isUpperCase(j))
                tmp.append(j);
            else if (j < 256) {
                tmp.append(pre);
                if (j < 16)
                    tmp.append("0");
                tmp.append(Integer.toString(j, 16));
            } else {
                tmp.append(pre + "u");
                tmp.append(Integer.toString(j, 16));
            }
        }
        return tmp.toString();
    }

    public static String escape(String src) {
        return escape(src, "%");
    }

    public static String unescape(String src) {
        return unescape(src, "%");
    }

    public static String unescape(String src, String pre) {
        if (src == null)
            return src;
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length());
        int lastPos = 0, pos = 0;
        char ch;
        while (lastPos < src.length()) {
            pos = src.indexOf(pre, lastPos);
            if (pos == lastPos) {
                if (src.charAt(pos + 1) == 'u') {
                    ch = (char) Integer.parseInt(src.substring(pos + 2, pos + 6), 16);
                    tmp.append(ch);
                    lastPos = pos + 6;
                } else {
                    ch = (char) Integer.parseInt(src.substring(pos + 1, pos + 3), 16);
                    tmp.append(ch);
                    lastPos = pos + 3;
                }
            } else {
                if (pos == -1) {
                    tmp.append(src.substring(lastPos));
                    lastPos = src.length();
                } else {
                    tmp.append(src.substring(lastPos, pos));
                    lastPos = pos;
                }
            }
        }
        return tmp.toString();
    }

    /**
     * 将通配符转换为正则表达式
     *
     * @param wildcard
     * @return
     */
    public static String wildcard2Reg(String wildcard) {

        //将pattern转换为正则表达式
        StringBuilder sb = new StringBuilder();
        sb.append("^");
        for (char c : wildcard.toCharArray()) {
            switch (c) {
                case '*':
                    sb.append(".+");
                    break;
                case '?':
                    sb.append(".{1}");
                    break;
                case '.':
                    sb.append("\\.");
                    break;
                default:
                    sb.append(c);
            }
        }
        sb.append("$");

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("[" + escape("asdf\rkkk\nEEEE\r\n") + "]");

        Map<Integer,String> mask = new HashMap<Integer, String>();
        mask.put((int)'很',"***");
        System.out.println(toUnicode("StringUtil很好用",mask));
    }
}
