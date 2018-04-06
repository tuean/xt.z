package com.tuean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by zhongxiaotian on 2018/3/7.
 */
@SpringBootApplication
@EnableScheduling
public class XtzApplication {

    private static Logger logger = LoggerFactory.getLogger(XtzApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(XtzApplication.class);
    }


}
