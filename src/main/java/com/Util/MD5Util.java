package com.Util;


import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

    private static final String salt = "3o4n2f8z";

    private static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    private static String inputPassToFormPass(String inputPass) {
        String  str =
                "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt;
        return md5(str);
    }

    public static String formPassToDBPass(String formPass, String salt) {
        String  str =
                "" + salt.charAt(1) + salt.charAt(4) + formPass + salt.charAt(2) + salt;
        return md5(str);
    }

    /**
     * 将表单输入的密码进行两次MD5加密
     * @param input 表单输入的密码字符串
     * @param saltDB 随机生成的salt字符串
     * @return 加密后的密码字符串
     */
    public static String inputPassToDBPass(String input, String saltDB) {
        String formPass = inputPassToFormPass(input);
        String dbPass = formPassToDBPass(formPass, saltDB);
        return dbPass;
    }
    public static void main(String[] args) {
        System.out.println(inputPassToFormPass("korob330203"));
    }
}
