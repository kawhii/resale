package com.sunrise.pack;

/**
 * 简单的加解密
 * @author Carl
 * @date 2016/6/15
 * <p/>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class SimplePackCrypter implements IPackCrypter {
    public static final int MODE_ENCRYPT = 0;
    public static final int MODE_DECRYPT = 1;

    private int[] encryptKeys = {
            0, 13, 10, 232, 1, 2, 3, 248, 4, 5, 6, 239, 7, 8, 9, 12, 154, 14, 244, 179, 15, 16, 17, 228, 18, 19, 141,
            20, 21, 22, 23, 24, 25, 26, 137, 206, 27, 28, 29, 30, 204, 31, 32, 202, 33, 240, 34, 35, 194, 36, 200, 37,
            182, 226, 38, 39, 224, 40, 41, 225, 42, 43, 44, 45, 142, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58,
            59, 60, 238, 61, 62, 133, 63, 243, 64, 195, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 162, 78, 79,
            80, 81, 82, 83, 84, 85, 86, 217, 87, 246, 88, 89, 90, 173, 91, 92, 93, 249, 94, 159, 95, 96, 245, 97, 98,
            99, 100, 101, 102, 103, 104, 164, 105, 106, 107, 108, 109, 110, 214, 111, 112, 175, 113, 216, 114, 115, 218,
            116, 221, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 220, 134, 135,
            136, 138, 139, 140, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 155, 199, 156, 157, 158, 160,
            161, 163, 165, 166, 167, 168, 169, 170, 171, 172, 174, 11, 176, 177, 178, 180, 181, 183, 184, 185, 186, 187,
            188, 189, 190, 191, 192, 193, 196, 197, 198, 201, 203, 205, 207, 208, 209, 210, 211, 212, 213, 215, 219,
            222, 223, 227, 229, 230, 231, 233, 234, 235, 236, 237, 241, 242, 247, 250, 251, 252, 253, 254, 255
    };
    private int[] decryptKeys = new int[encryptKeys.length];
    private int[] keys;

    {
        for (int i = 0; i < encryptKeys.length; i++) {
            decryptKeys[encryptKeys[i]] = i;
        }
    }

    public SimplePackCrypter(int mode) {

        keys = MODE_ENCRYPT == mode ? encryptKeys : decryptKeys;
    }

    @Override
    public byte update(byte b) {
        return (byte) keys[b < 0 ? 256 + b : b];
    }

    @Override
    public int update(int i) {
        return i;
    }
}
