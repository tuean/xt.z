package com.tuean.steps.impl;

import com.tuean.annotation.StepOrder;
import com.tuean.steps.ISteps;
import com.tuean.config.StepConfig;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhongxiaotian on 2018/5/1.
 */
@StepOrder(order = 3)
public class GetToLoginUrl implements ISteps {

    @Value("${bid.url}")
    private String givenUrl;

    @Override
    public void work(StepConfig stepConfig) {
        // get the normal webDriver
        WebDriver webDriver = stepConfig.getWebDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        // open the given url
        webDriver.get(givenUrl);
        // find the network operator
//        WebElement e = webDriver.findElement();
    }
}
