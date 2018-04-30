package com.tuean.util;

import org.openqa.selenium.WebDriver;

/**
 * Created by zhongxiaotian on 2018/4/30.
 */
public class ThreadLocalUtil {

    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal();

    public static void set(WebDriver source){
        threadLocal.set(source);
    }

    public static WebDriver get(){
        return threadLocal.get();
    }

    public static void clear(){
        threadLocal.remove();
    }
}
