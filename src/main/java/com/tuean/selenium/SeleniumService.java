package com.tuean.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 通过 selenium 登录进入拍卖网站
 * @author zhongxiaotian
 * @date 2018/3/4
 */
@Service
public class SeleniumService {


    /**
     * 车牌地址
     */
    @Value("${paimai.url}")
    private String paimaiUrl;

    public static void start(String paimaiUrl) throws Exception{

        WebDriver webDriver =  new SafariDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        webDriver.get(paimaiUrl);

        Thread.sleep(1000);
        WebElement logo = webDriver.findElement(By.className("index-logo-srcnew"));
        Thread.sleep(1000);
        logo.click();
        System.out.println(logo.getLocation().x);

        File srcFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("c:\\1.png"));
    }

    public static void main(String[] args) throws Exception{
        start("http://www.baidu.com");
    }
}
