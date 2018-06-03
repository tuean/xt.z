package com.tuean.steps.impl;

import com.tuean.annotation.StepOrder;
import com.tuean.steps.ISteps;
import com.tuean.config.StepConfig;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongxiaotian on 2018/5/1.
 */
@StepOrder(order = 1)
public class PreConfigs implements ISteps{

    private static Logger logger = LoggerFactory.getLogger(PreConfigs.class);

    public static List<Class> getBrowseDriverList(){
        List<Class> list = new ArrayList<>();
        list.add(SafariDriver.class);
        list.add(ChromeDriver.class);
        list.add(InternetExplorerDriver.class);
        return list;
    }

    public static String defaultFilePath(){
        return "/Users/zhongxiaotian/Desktop/";
    }

    @Override
    public void work(StepConfig stepConfig) {
        logger.info("Configuration completed");
        stepConfig.next();
    }
}
