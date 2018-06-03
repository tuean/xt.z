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

    private Map classMap = new TreeMap();

    private static int instantOrder;

    private WebDriver webDriver;

    @PostConstruct
    public void init(){
        Map<Integer, Class> map = getClassByPackage("com.tuean.steps");
        if(map != null && !map.isEmpty()){
            setclassMap(map);
        }else{
            logger.warn("no steps configured");
            end();
        }
    }

    public void start(){
        Iterator iterator = classMap.entrySet().iterator();
        if (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            Class clazz = (Class) entry.getValue();
            try {
                Method method =  clazz.getMethod("work");
                setInstantOrder((Integer) entry.getKey());
                method.invoke(this);
            } catch (Exception var){
                var.printStackTrace();
            }
        }
    }

    public void next(){
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
                    Method method =  clazz.getMethod("work");
                    setInstantOrder((Integer) entry.getKey());
                    method.invoke(this);
                } catch (Exception var){
                    var.printStackTrace();
                }
            }
        }
    }

    public void end(){
        logger.info("got to end");
        System.gc();
        System.exit(0);
    }


    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public Map getclassMap() {
        return classMap;
    }

    public void setclassMap(Map classMap) {
        this.classMap = classMap;
    }

    public static int getInstantOrder() {
        return instantOrder;
    }

    public static void setInstantOrder(int instantOrder) {
        StepConfig.instantOrder = instantOrder;
    }
}
