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
 * Created by zhongxiaotian on 2018/6/11.
 */
@StepOrder(order = 5)
public class Step5_Confirm implements ISteps{

    private static Logger logger = LoggerFactory.getLogger(Step5_Confirm.class);


    @Override
    public void work() {

        WebDriver webDriver = StepConfig.getWebDriver();


        // confirm
        try {
            // get confirm button //*[@id="testBtnConfirm"]
            WebElement confirmButton = webDriver.findElement(By.xpath("//*[@id=\"testBtnConfirm\"]"));

            // initate mouse behavior
//            Actions actions = new Actions(webDriver);
//            actions.click(searchButton);
            confirmButton.click();
        } catch (Exception var){
            logger.error("find confirm button error");
            var.printStackTrace();
        }


        // agree
        try {
            // get agree button //*[@id="protocolBtnConfirm"]
            WebElement agreeButton = webDriver.findElement(By.xpath("//*[@id=\"protocolBtnConfirm\"]"));

            agreeButton.click();
        } catch (Exception var) {
            logger.error("find agree button error");
            var.printStackTrace();
        }

        logger.info(webDriver.getCurrentUrl());

        StepConfig.next();
    }
}
