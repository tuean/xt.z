package com.tuean.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhongxiaotian on 2018/4/6.
 */
@RestController
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);


    public static void main(String[] args) {
        Integer a = new Integer(1);
        Integer b = new Integer(1);

        System.out.println(a.equals(b));
    }
}
