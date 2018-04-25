package com.Util;

public class SaltUtil {

    private static String str = "abcdefghijklmnopqrstuvwxyz";

    private static int getRandom(int len) {
        return (int)Math.round((Math.random() * len));
    }

    public static String getSalt(int length) {
        StringBuffer sb = new StringBuffer();
        int len = str.length();
        for (int i = 0; i < length; i++) {
            sb.append(str.charAt(getRandom(len - 1)));
        }
        return sb.toString();
    }

}
