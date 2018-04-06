package com.tuean.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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

    public void start() throws Exception{


        WebDriver dr =  new SafariDriver();
//        dr.manage().window().maximize();
//        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        dr.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        dr.get(url);

//        Thread.sleep(1000);
//        WebElement logo = dr.findElement(By.xpath("//img[@src='//www.baidu.com/img/bd_logo1.png']"));
//        Thread.sleep(1000);
//        logo.click();
//        System.out.println(logo.getLocation().x);





    }
}
