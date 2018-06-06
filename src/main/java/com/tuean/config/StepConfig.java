package com.tuean.config;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.*;

import static com.tuean.util.ReflectionUtls.getClassByPackage;

/**
 * Created by zhongxiaotian on 2018/4/30.
 */
@Component
public class StepConfig {

    private static Logger logger = LoggerFactory.getLogger(StepConfig.class);

    private static class SingletonHolder {
        private static final StepConfig INSTANCE = new StepConfig();
    }
    private StepConfig (){}
    public static final StepConfig getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static Map classMap = new TreeMap();

    private static int instantOrder;

    private static WebDriver webDriver;

    @PostConstruct
    public static void init(){
        Map<Integer, Class> map = getClassByPackage("com.tuean.steps");
        if(map != null && !map.isEmpty()){
            setClassMap(map);
        }else{
            logger.warn("no steps configured");
            end();
        }
    }

    public static void next(){
        boolean nextFlag = false;
        Iterator iterator = classMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            if ((Integer) entry.getKey() == instantOrder){
                nextFlag = true;
                continue;
            }
            if (nextFlag){
                Class clazz = (Class) entry.getValue();
                try {
                    Method method =  clazz.getMethod("work", StepConfig.class);
                    setInstantOrder((Integer) entry.getKey());
                    method.invoke(clazz.newInstance(), StepConfig.getInstance());
                } catch (Exception var){
                    var.printStackTrace();
                }
            }
        }
    }

    public static void end(){
        logger.info("got to end");
        System.gc();
        System.exit(0);
    }


    public static Map getClassMap() {
        return classMap;
    }

    public static void setClassMap(Map classMap) {
        StepConfig.classMap = classMap;
    }

    public static int getInstantOrder() {
        return instantOrder;
    }

    public static void setInstantOrder(int instantOrder) {
        StepConfig.instantOrder = instantOrder;
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        StepConfig.webDriver = webDriver;
    }
}
