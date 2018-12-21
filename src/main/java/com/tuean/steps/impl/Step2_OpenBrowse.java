package com.tuean.steps.impl;

import com.tuean.annotation.StepOrder;
import com.tuean.steps.ISteps;
import com.tuean.config.StepConfig;
import com.tuean.config.WebDriverPreConfig;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Created by zhongxiaotian on 2018/4/30.
 */
@StepOrder(order = 2)
public class Step2_OpenBrowse implements ISteps{

    private static Logger logger = LoggerFactory.getLogger(Step2_OpenBrowse.class);

    @Override
    public void work(){
        WebDriver webDriver = null;
        List<Class> driverList = WebDriverPreConfig.getBrowseDriverList();
        if(webDriver == null){
            for(Class clazz : driverList){
                try{
                    webDriver = (WebDriver) clazz.newInstance();
                    // 加上页面查询元素等待时间
                    webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    // script timeout
                    webDriver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
                    // pageLoad timeout
                    webDriver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
                    break;
                }catch(Exception var){
                    logger.error("cannot find " + clazz.getName());
                }
            }
        }

        if(webDriver != null){
            StepConfig.setWebDriver(webDriver);
            StepConfig.next();
        }else{
            logger.error("cannot find webDriver, please check this computer");
            StepConfig.end();
        }
    }


}
