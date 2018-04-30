package com.tuean.steps;

import com.tuean.annotation.StepOrder;
import com.tuean.util.StepConfig;
import com.tuean.util.ThreadLocalUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongxiaotian on 2018/4/30.
 */
@StepOrder(order = 1)
public class OpenBrowse {

    private static Logger logger = LoggerFactory.getLogger(OpenBrowse.class);

    public void step(StepConfig stepConfig){
        WebDriver webDriver = null;
        List<Class> driverList = getBrowseDriverList();
        if(webDriver == null){
            for(Class clazz : driverList){
                try{
                    webDriver = (WebDriver) clazz.newInstance();
                    break;
                }catch(Exception var){
                    logger.error("cannot find " + clazz.getName());
                }
            }
        }

        if(webDriver != null){
            ThreadLocalUtil.set(webDriver);
            stepConfig.doNext();
        }else{
            logger.error("cannot find webDriver, please check this computer");
        }
    }

    private static List<Class> getBrowseDriverList(){
        List<Class> list = new ArrayList<>();
        list.add(SafariDriver.class);
        list.add(ChromeDriver.class);
        list.add(InternetExplorerDriver.class);
        return list;
    }





}
