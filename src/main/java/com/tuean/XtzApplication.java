package com.tuean;

import com.tuean.Swing.ConfigFrame;
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
//        WebDriverPreConfig preConfig = new WebDriverPreConfig();

        // 启动信息设置面板
        ConfigFrame configFrame = new ConfigFrame();
        configFrame.createAndShowGUI();


//        SpringApplication.run(XtzApplication.class);
//        Starter starter = new Starter();
//        starter.start();

    }

}
