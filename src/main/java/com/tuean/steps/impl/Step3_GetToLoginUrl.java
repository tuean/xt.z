package com.tuean.steps.impl;

import com.tuean.annotation.StepOrder;
import com.tuean.steps.ISteps;
import com.tuean.config.StepConfig;
import com.tuean.util.PropertiesUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhongxiaotian on 2018/5/1.
 */
@StepOrder(order = 3)
public class Step3_GetToLoginUrl implements ISteps {

    private static Logger logger = LoggerFactory.getLogger(Step3_GetToLoginUrl.class);


    @Override
    public void work() {
        // get the normal webDriver
        WebDriver webDriver = StepConfig.getWebDriver();
//        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        // open the given url
        String givenUrl = PropertiesUtils.bidGet("bid.url");
        logger.info("instant url is:{}", givenUrl);
        Assert.notNull(givenUrl, "instant url is empty");
        webDriver.get(givenUrl);
        // find the network operator
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"u1\"]/a[1]"));

        element.click();

        StepConfig.next();
    }
}
