package com.tuean.steps;

import com.tuean.steps.impl.Step1_PreConfigs;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class WebDriverPreConfig {

    private static Logger logger = LoggerFactory.getLogger(Step1_PreConfigs.class);

    private static List<Class> list;

    static {
        list = new ArrayList<>();
        list.add(SafariDriver.class);
        list.add(ChromeDriver.class);
        list.add(InternetExplorerDriver.class);
    }

    public List<Class> getBrowseDriverList() {
        return list;
    }


}
