package com.sunrise.pack;

/**
 * 实现简单的加解密功能
 *
 * @author kinz
 * @version 1.0 5/14/2015
 * @since JDK1.6
 */
public interface IPackCrypter {

    byte update(byte b);

    int update(int i);
}