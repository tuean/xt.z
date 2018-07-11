package com.tuean.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhongxiaotian on 2018/6/22.
 */
public class TimeUtils {

    private static Logger logger = LoggerFactory.getLogger(TimeUtils.class);

    public static long getNow(){
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        System.out.println(getNow());
        System.out.println(System.nanoTime());
        System.out.println(LocalDateTime.now());
    }


    public static Date getSecondsBefore(Date source, Long seconds){
        Assert.notNull(source, "current date cannot be null");
        Integer sec = seconds != null ? seconds.intValue()*(-1) : 0;
        logger.info("date will be ");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(source);
        calendar.add(Calendar.SECOND, sec);
        return calendar.getTime();
    }
}
