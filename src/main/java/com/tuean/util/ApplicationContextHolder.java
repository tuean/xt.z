package com.tuean.util;

import org.springframework.beans.BeansException;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by zhongxiaotian on 2017/11/28.
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {
    private static ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        ApplicationContextHolder.context = context;
    }

    public static ApplicationContext getContext(){
        return context;
    }

    /**
     * 根据bean name 获取实例
     * @param beanName
     * @return
     */
    public static Object getBeanByName(String beanName) {
        if (beanName == null || context == null) {
            return null;
        }
        return context.getBean(beanName);
    }

    /**
     * 只适合一个class只被定义一次的bean（也就是说，根据class不能匹配出多个该class的实例）
     * singleton
     * @param clazz
     * @return
     */
    public static Object getBeanByType(Class clazz) {
        if (clazz == null || context == null) {
            return null;
        }
        return context.getBean(clazz);
    }

    public static String[] getBeanDefinitionNames() {
        return context.getBeanDefinitionNames();
    }


    /**
     * stop the server
     */
    public static void stopServer(){
        ServletWebServerApplicationContext context = (ServletWebServerApplicationContext) ApplicationContextHolder.getContext();
        if (context != null) {
            context.getWebServer().stop();
        }
    }

}
