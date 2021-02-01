package com.tuean.helper;

import com.tuean.util.StringUtils;

public class VerificationCodeHelper {

    private static volatile String code;


    public static void setCode(String input) {
        code = input;
    }

    public static String getCode() {
        if (StringUtils.isEmpty(code)) return null;
        return code.trim();
    }




}

