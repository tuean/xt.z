package com.tuean.steps.impl;

import com.tuean.annotation.StepOrder;
import com.tuean.config.StepConfig;
import com.tuean.steps.ISteps;
import com.tuean.util.PropertiesUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.swing.*;

/**
 * Created by zhongxiaotian on 2018/6/4.
 */
@StepOrder(order = 4)
public class Step4_FillingIn implements ISteps {

    private static Logger logger = LoggerFactory.getLogger(Step4_FillingIn.class);

    @Autowired
    private PropertiesUtils propertiesUtils;

    @Override
    public void work() {
        WebDriver webDriver = StepConfig.getWebDriver();

        try {

            // bidNumber
            WebElement bidNumberInput = webDriver.findElement(By.xpath("//*[@id=\"bidnumber\"]"));
            String bidNumber = propertiesUtils.get("bid.number");
            bidNumberInput.sendKeys(bidNumber);

            // bidPassword
            WebElement bidPasswordInput = webDriver.findElement(By.xpath("//*[@id=\"bidpassword\"]"));
            String bidPassword = propertiesUtils.get("bid.password");
            bidPasswordInput.sendKeys(bidPassword);

            // auth code
            WebElement authCodeInput = webDriver.findElement(By.xpath("//*[@id=\"imagenumber\"]"));
            // todo Semi - automatic change to automatic
            String authCode = JOptionPane.showInputDialog("输入验证码:");
            authCodeInput.sendKeys(authCode);

            // 参加投标竞买
            WebElement toBidClick = webDriver.findElement(By.xpath("//*[@id=\"btnlogin\"]"));
            toBidClick.click();
            toBidClick.submit();

            StepConfig.next();

        } catch (Exception var){
            logger.error("something wrong in login in page");
            logger.info("pausing");
            var.printStackTrace();
        }

    }
}
