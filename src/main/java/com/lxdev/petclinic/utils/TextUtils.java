/**
 * @author eddeveloper <ed.developer90@gmail.com>
 * Date :  2021-05-03
 * Time : 10:40 PM
 */
package com.lxdev.petclinic.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TextUtils {
    private final static String CHARS = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890";
    private static int CHAR_LEN = CHARS.length();

    public static String randomToken(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(CHARS.charAt((int) (Math.random() * CHAR_LEN)));
        }

        return sb.toString();
    }

    public static String sha1(String text) {

        MessageDigest crypt = null;
        try {
            crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(text.getBytes("UTF-8"));
            return new BigInteger(1, crypt.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
