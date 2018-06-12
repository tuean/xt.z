package com.tuean.steps.impl;

import com.tuean.annotation.StepOrder;
import com.tuean.config.StepConfig;
import com.tuean.steps.ISteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhongxiaotian on 2018/6/4.
 */
@StepOrder(order = 4)
public class Step4_FillingIn implements ISteps {

    private static Logger logger = LoggerFactory.getLogger(Step4_FillingIn.class);

    @Override
    public void work() {
        WebDriver webDriver = StepConfig.getWebDriver();

        // find the input of baidu
        WebElement input = webDriver.findElement(By.xpath("//*[@id=\"kw\"]"));

        // filling in something
        String searchText = "tuean";
        input.sendKeys(searchText);

        // log the thing that you search
        logger.info(searchText);

        StepConfig.next();

    }
}
