package com.tuean;

import com.tuean.Swing.LoginConfigFrame;
import com.tuean.steps.impl.Step1_PreConfigs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * Created by zhongxiaotian on 2018/3/7.
 */
@SpringBootApplication
@EnableScheduling
@PropertySource("classpath:/bid.properties")
public class XtzApplication {

    private static Logger logger = LoggerFactory.getLogger(XtzApplication.class);

    public static void main(String[] args) {

        // 预先设置


        // 启动登录信息设置面板
        LoginConfigFrame loginConfigFrame = new LoginConfigFrame();
        loginConfigFrame.createAndShowGUI();

        // 启动策略设置面板

//        SpringApplication.run(XtzApplication.class);
//        Starter starter = new Starter();
//        starter.start();

    }

}
