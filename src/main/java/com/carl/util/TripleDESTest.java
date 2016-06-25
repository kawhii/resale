package com.carl.util;

import java.io.IOException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author Carl
 * @date 2016/6/23
 * <p/>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */

@SuppressWarnings("restriction")
public class TripleDESTest {

    /**
     * 根据参数生成Key;
     *
     * @param strKey
     */
    private Key getKey(String strKey) {
        Key key = null;
        try {
            KeyGenerator _generator = KeyGenerator.getInstance("DES");
            _generator.init(new SecureRandom(strKey.getBytes()));
            key = _generator.generateKey();
            _generator = null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return key;
    }

    /**
     * 获得一次3DES加密后的密文
     *
     * @param
     * @return strMi
     */
    public String getEncString(String strMing, String strKey) {
        byte[] byteMi = null;
        byte[] byteMing = null;
        String strMi = "";
        Key key = getKey(strKey);
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            byteMing = strMing.getBytes("utf-8");
            byteMi = getEncCode(byteMing, key);
            strMi = encoder.encode(byteMi);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            encoder = null;
            byteMi = null;
            byteMing = null;
        }
        return strMi;
    }

    /**
     * 获得两次3DES加密后的密文
     *
     * @param
     * @return strMi
     */
    public String getTwiceEncString(String strMing, String strKey) {
        return getEncString(getEncString(strMing, strKey), strKey);
    }

    /**
     * 获得一次3DES解密后的明文
     *
     * @param
     * @return strMing
     */
    public String getDecString(String strMi, String strKey) {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] byteMing = null;
        byte[] byteMi = null;
        String strMing = "";
        Key key = getKey(strKey);
        try {
            byteMi = base64Decoder.decodeBuffer(strMi);
            byteMing = getDecCode(byteMi, key);
            strMing = new String(byteMing, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            base64Decoder = null;
            byteMing = null;
            byteMi = null;
        }
        return strMing;
    }

    /**
     * 获得两次3DES解密后的明文
     *
     * @param
     * @return strMing
     */
    public String getTwiceDecString(String strMi, String strKey) {
        return getDecString(getDecString(strMi, strKey), strKey);
    }

    /**
     * 获得一次3DES加密后的密文
     *
     * @param byts
     * @return
     */
    private byte[] getEncCode(byte[] byts, Key key) {
        byte[] byteFina = null;
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byteFina = cipher.doFinal(byts);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cipher = null;
        }
        return byteFina;
    }

    /**
     * 获得一次3DES解密后的明文
     *
     * @param bytd
     * @return
     */
    private byte[] getDecCode(byte[] bytd, Key key) {
        byte[] byteFina = null;
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byteFina = cipher.doFinal(bytd);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cipher = null;
        }
        return byteFina;
    }

    public static void main(String[] args) {
       /* String key = "123";
        String str = "1";
        byte b = 13 << 321;
        System.out.println(b);
        System.out.println(b>>  Integer.MAX_VALUE >> 321);
        TripleDESTest td = new TripleDESTest();
        Key k = td.getKey(key);
        System.out.println("获得的密钥key是:" + k);
        String encyStr = td.getEncString(str, key);
        System.out.println("一次加密后的密文是:" + encyStr);
        String decyStr = td.getDecString(encyStr, key);
        System.out.println("一次解密后的明文是:" + decyStr);
        encyStr = td.getTwiceEncString(str, key);
        System.out.println("两次加密后的密文是:" + encyStr);
        decyStr = td.getTwiceDecString(encyStr, key);
        System.out.println("两次解密后的明文是:" + decyStr);*/
        System.out.println(Math.random());
        System.out.println(1 - Math.sin(Math.PI/1));
    }

}
