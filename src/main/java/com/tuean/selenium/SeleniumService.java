package com.tuean.selenium;

import org.springframework.beans.factory.annotation.Value;
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
    @Value("${bid.url}")
    private String paimaiUrl;


}
