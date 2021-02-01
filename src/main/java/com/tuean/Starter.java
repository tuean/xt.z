package com.tuean;

import com.tuean.Swing.ConfigFrame;
import com.tuean.Swing.Console;
import com.tuean.Swing.Input;
import com.tuean.Swing.JConsole.JConsole;
import com.tuean.config.WebDriverPreConfig;
import com.tuean.helper.MineLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;


/**
 * Created by zhongxiaotian on 2018/3/7.
 */
@SpringBootApplication
@EnableScheduling
@PropertySource("classpath:/bid.properties")
public class Starter {

    private static Logger logger = LoggerFactory.getLogger(Starter.class);

    public static void main(String[] args) throws IOException {

        // 控制台输出
//        Console console = new Console();
//        console.init();
        JConsole console = new JConsole(100, 40);
        MineLogger.setJC(console);

        // 预先设置
        WebDriverPreConfig preConfig = new WebDriverPreConfig();

        // 用户输入
        Input input = new Input();
        input.createAndShowGUI();

        // 后台定时任务
//        CurrentPageTask pageTask = new CurrentPageTask();
//        pageTask.run();

        // 启动信息设置面板
        ConfigFrame configFrame = new ConfigFrame();
        configFrame.createAndShowGUI();


    }

}
