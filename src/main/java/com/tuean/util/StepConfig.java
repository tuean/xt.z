package com.tuean.util;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongxiaotian on 2018/4/30.
 */
public class StepConfig {

    private List<Class> classList = new ArrayList<>();

    private WebDriver webDriver;

    public void next(){

    }

    public void end(){

    }

    public List<Class> getClassList() {
        return classList;
    }

    public void setClassList(List<Class> classList) {
        this.classList = classList;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
