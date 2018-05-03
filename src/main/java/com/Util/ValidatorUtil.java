package com.Util;

import org.thymeleaf.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {

    public static final Pattern TELEPHONE_PATTERN = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");

    public static boolean isTelephone(String src) {

        if(StringUtils.isEmpty(src)) {
            return false;
        }
        Matcher matcher = TELEPHONE_PATTERN.matcher(src);
        return matcher.matches();
    }
    public static void main(String[] args) {
        System.out.println(isTelephone("15306585680"));
    }
}
