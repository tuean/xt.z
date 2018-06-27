package com.tuean.util;

import java.time.LocalDateTime;

/**
 * Created by zhongxiaotian on 2018/6/22.
 */
public class TimeUtils {

    public static long getNow(){
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        System.out.println(getNow());
        System.out.println(System.nanoTime());
        System.out.println(LocalDateTime.now());
    }
}
