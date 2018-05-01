package com.tuean.steps;

import com.tuean.util.StepConfig;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongxiaotian on 2018/5/1.
 */
public class PreConfigs {

    public static List<Class> getBrowseDriverList(){
        List<Class> list = new ArrayList<>();
        list.add(SafariDriver.class);
        list.add(ChromeDriver.class);
        list.add(InternetExplorerDriver.class);
        return list;
    }

}
