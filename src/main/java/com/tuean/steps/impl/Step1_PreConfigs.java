package com.tuean.steps.impl;

import com.tuean.annotation.StepOrder;
import com.tuean.consont.SystemParam;
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
public class Step1_PreConfigs implements ISteps{

    private static Logger logger = LoggerFactory.getLogger(Step1_PreConfigs.class);

    private static List<Class> list = new ArrayList<>();

    /**
     * 设定可使用的浏览器类型
     *
     * @return
     */
    public static List<Class> getBrowseDriverList(){
        return list;
    }

    public static String defaultFilePath(){
        return SystemParam.PROJECT_PATH + "/tmp/";
    }

    @Override
    public void work() {
        list.add(SafariDriver.class);
        list.add(ChromeDriver.class);
        list.add(InternetExplorerDriver.class);

        logger.info("Configuration completed");
        StepConfig.next();
    }
}
