package com.tuean;

import com.tuean.config.StepConfig;
import com.tuean.entity.BidPolicy;
import com.tuean.steps.Starter;
import com.tuean.util.ApplicationContextHolder;
import com.tuean.util.ReflectionUtls;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.tuean.util.ReflectionUtls.getClassByPackage;

/**
 * Created by zhongxiaotian on 2018/3/7.
 */
@SpringBootApplication
@EnableScheduling
public class XtzApplication {

    private static Logger logger = LoggerFactory.getLogger(XtzApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(XtzApplication.class);
//        Starter starter = new Starter();
//        starter.start();

        // auto stop
        ApplicationContextHolder.stopServer();
    }

}
