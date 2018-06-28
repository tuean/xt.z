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
    @Value("${bid.url}")
    private String paimaiUrl;


}
