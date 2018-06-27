package com.tuean.aop;

import com.tuean.config.StepConfig;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by zhongxiaotian on 2018/6/11.
 */
@Aspect
public class CurrentUrlAop {

    private static Logger logger = LoggerFactory.getLogger(CurrentUrlAop.class);

    public CurrentUrlAop(){}

    @Pointcut("execution(* com.tuean.controller..*.*(..))")
    public void urlLog() {
    }

    @Before("urlLog()")
    public void beforeWork(JoinPoint joinPoint) throws Exception{
        WebDriver webDriver = StepConfig.getWebDriver();
        logger.info("before work url: ?", webDriver.getCurrentUrl());
    }

    public void afterWork(JoinPoint joinPoint) throws Exception{
        WebDriver webDriver = StepConfig.getWebDriver();
        logger.info("after work url: ?", webDriver.getCurrentUrl());
    }


    public static void main(String[] args) {
        String source = "asdjnuashasdh";

        // 第一种 高级写法
        long result = Arrays.asList(source.split("")).stream().filter(n -> "a".equals(n)).count();
        System.out.println(result);

        // 第二种 基础写法
        long result2 = 0;
        String[] sources = source.split("");
        for(int x = 0; x < sources.length; x++){
            if("a".equals(sources[x])){
                result2++;
//                result2 = result2 + 1;  这一行和上一行作用一毛一样
            }
        }
        System.out.println(result2);
    }


}
