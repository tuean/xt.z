package com.tuean.steps.impl;

import com.tuean.annotation.StepOrder;
import com.tuean.steps.ISteps;
import com.tuean.config.StepConfig;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * Created by zhongxiaotian on 2018/4/30.
 */
@StepOrder(order = 2)
public class OpenBrowse implements ISteps{

    private static Logger logger = LoggerFactory.getLogger(OpenBrowse.class);

    @Override
    public void work(StepConfig stepConfig){
        WebDriver webDriver = null;
        List<Class> driverList = PreConfigs.getBrowseDriverList();
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
            stepConfig.setWebDriver(webDriver);
            stepConfig.next();
        }else{
            logger.error("cannot find webDriver, please check this computer");
            stepConfig.end();
        }
    }


}
