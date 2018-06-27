package com.tuean.steps.impl;

import com.tuean.annotation.StepOrder;
import com.tuean.steps.ISteps;
import com.tuean.config.StepConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhongxiaotian on 2018/5/1.
 */
@StepOrder(order = 3)
public class Step3_GetToLoginUrl implements ISteps {

    private static String givenUrl;

    @Value("${bid.url}")
    private void setBidUrl(String bidUrl){
        Step3_GetToLoginUrl.givenUrl = bidUrl;
    }

    @Override
    public void work() {
        // get the normal webDriver
        WebDriver webDriver = StepConfig.getWebDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        // open the given url
        webDriver.get(givenUrl);
        // find the network operator
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"lilink\"]/a[1]"));

        element.click();

        StepConfig.next();
    }
}
