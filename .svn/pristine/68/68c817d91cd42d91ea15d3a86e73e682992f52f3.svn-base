package com.cwkj.ysms.util;

import java.security.MessageDigest;

/**
 * MD5加密类
 * 利用MD5对数据进行加密
 * @author chrismacong
 * @since 2015-03-04
 */
public class MD5Util {
    public final static String MD5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
        try {
            byte[] btInput = s.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            String new_str = new String(str);
            return new_str.toLowerCase();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}