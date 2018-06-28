package com.tuean.lab;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Created by zhongxiaotian on 2018/6/28.
 */
public class FunctionalTest {

    public static void main(String[] args) throws Exception{
        WebDriver webDriver =  new ChromeDriver();
        webDriver.manage().window().maximize();
        // 加上页面查询元素等待时间
        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        // script timeout
        webDriver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
        // pageLoad timeout
        webDriver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        webDriver.get("https://www.baidu.com");
        WebDriverWait wait = new WebDriverWait(webDriver, 60);



        WebElement input = webDriver.findElement(By.xpath("//*[@id=\"kw\"]"));
        input.sendKeys("tuean");
//        input.sendKeys(Keys.ENTER);

        wait.until(wDriver -> String.valueOf(((JavascriptExecutor) wDriver).executeScript("return document.readyState")).equals("complete"));

        WebElement search = webDriver.findElement(By.xpath("//*[@id=\"su\"]")).findElement(By.xpath(".."));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"su\"]")));

//        Thread.sleep(10000L);

        search.click();


//        if(webDriver.findElement(By.xpath("//*[@id=\"lg\"]/img[2]")).isDisplayed()){
//            String previousURL = webDriver.getCurrentUrl();
//            webDriver.findElement(By.xpath("//*[@id=\"lg\"]/img[2]")).click();
//            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//            ExpectedCondition e = new ExpectedCondition<Boolean>() {
//                @Override
//                public Boolean apply(WebDriver d) {
//                    return (d.getCurrentUrl() != previousURL);
//                }
//            };
//
//            wait.until(e);
//            System.out.println(webDriver.getCurrentUrl());
//        }




//        System.out.println(logo.getLocation().x);

        // get the screenshots of the whole window
        // save the pic by the given path
//        File srcFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
//        String filePath = "/Users/zhongxiaotian/Desktop/tmp" + System.currentTimeMillis();
//        FileUtils.copyFile(srcFile, new File(filePath));

//        WebElement input = webDriver.findElement(By.xpath("//*[@id=\"kw\"]"));
//
//        input.sendKeys("tuean");
//
//        WebElement searchButton = webDriver.findElement(By.xpath("//*[@id=\"su\"]"));
//
//        searchButton.click();
    }

    protected static Function<WebDriver, Boolean> isPageLoaded() {
        return new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
    }

    public static void waitForPageLoad(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(isPageLoaded());
    }
}
