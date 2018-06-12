package com.tuean.steps.impl;


import com.tuean.config.StepConfig;
import com.tuean.steps.ISteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhongxiaotian on 2018/6/11.
 */
public class Step5_Click implements ISteps{

    private static Logger logger = LoggerFactory.getLogger(Step5_Click.class);


    @Override
    public void work() {
        WebDriver webDriver = StepConfig.getWebDriver();



        // do search
        WebElement searchButton = webDriver.findElement(By.xpath("//*[@id=\"su\"]"));
//        try{
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        searchButton.click();

        // initate mouse behavior
        Actions actions = new Actions(webDriver);
        actions.click(searchButton);

        logger.info(webDriver.getCurrentUrl());
    }
}
