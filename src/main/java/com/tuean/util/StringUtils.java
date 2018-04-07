package com.tuean.util;

import java.util.Random;

/**
 * Created by zhongxiaotian on 2018/4/7.
 */
public class StringUtils {


    public static String randomString(int num){
        if(num <= 0){
            throw new IllegalArgumentException();
        }
        String source = "abcdefghijklmnopqrstuvwxyz0123456789";
        char[] cs = new char[num];
        for(int x = 0; x < num; x++){
            cs[x] = source.charAt(new Random().nextInt(source.length()));
        }
        return new String(cs);
    }

}
