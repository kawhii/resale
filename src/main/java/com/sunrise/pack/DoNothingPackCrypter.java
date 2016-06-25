package com.sunrise.pack;


/**
 * @author Carl
 * @date 2016/6/15
 * <p/>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class DoNothingPackCrypter implements IPackCrypter {
    @Override
    public byte update(byte b) {
        return b;
    }

    @Override
    public int update(int i) {
        return i;
    }
}
