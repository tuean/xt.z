package com.tuean.aop;

import com.tuean.config.StepConfig;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by zhongxiaotian on 2018/6/11.
 */
@Aspect
@Component
public class CurrentUrlAop {

    private static Logger logger = LoggerFactory.getLogger(CurrentUrlAop.class);

    public CurrentUrlAop(){}

    @Pointcut("execution(* com.tuean.controller..*.*(..))")
    public void urlLog() {
    }

    @Before("urlLog()")
    public void beforeWork(JoinPoint joinPoint) throws Exception{
        WebDriver webDriver = StepConfig.getWebDriver();
        logger.info("before work url: {}", webDriver.getCurrentUrl());
        logger.info("current order is {}", StepConfig.getInstantOrder());
    }

    @After("urlLog()")
    public void afterWork(JoinPoint joinPoint) throws Exception{
        WebDriver webDriver = StepConfig.getWebDriver();
        logger.info("after work url: ?", webDriver.getCurrentUrl());
    }



}
