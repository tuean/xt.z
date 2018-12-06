package com.tuean.Swing;

import com.tuean.config.LoginConfig;
import com.tuean.consont.SystemParam;
import com.tuean.steps.impl.Step2_OpenBrowse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 登录窗口ui
 */
public class ConfigFrame {

    private static Logger logger = LoggerFactory.getLogger(ConfigFrame.class);


    /**{
     * 创建并显示GUI。出于线程安全的考虑，
     * 这个方法在事件调用线程中调用。
     */
    public void createAndShowGUI() {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("标书信息");
        // Setting the width and height of frame
//        frame.setSize(350, 200);
        //获取屏幕大小
        Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 350, screenSize.height);
        frame.setLocation(0, 0);
        JPanel login = new JPanel();
        // 添加登录面板
        frame.add(login);
        placeComponents(login);
        // 策略面板
        JPanel policy = new JPanel();
        frame.add(policy);
        placePolicy(policy);

        frame.setVisible(true);
    }

    /**
     * 登录部分
     * @param panel
     */
    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);
        // 标书号
        JLabel userLabel = new JLabel("标书号:");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        // 标书密码
        JLabel passwordLabel = new JLabel("标书密码:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);
        JTextField passwordText = new JTextField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        // 身份证号
        JLabel identityLabel = new JLabel("身份证号：");
        identityLabel.setBounds(10, 80, 80, 25);
        panel.add(identityLabel);
        JTextField identityText = new JTextField();
        identityText.setBounds(100, 80, 165, 25);
        panel.add(identityText);

        // 创建登录按钮
        JButton loginButton = new JButton("启动浏览器");
        loginButton.setBounds(40, 140, 200, 25);

        panel.add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.info("标书号：" + userText.getText());
                logger.info("标书密码：" + passwordText.getText());
                logger.info("身份证号：" + identityText.getText());
                LoginConfig loginConfig = new LoginConfig();
                loginConfig.setIdentify(identityText.getText());
                loginConfig.setPassword(passwordText.getText());
                loginConfig.setUser(userText.getText());
                SystemParam.loginConfig = loginConfig;

                // 打开浏览器
                Step2_OpenBrowse openBrowse = new Step2_OpenBrowse();
                openBrowse.work();
            }
        });
    }

    /**
     * 策略部分
     * @param panel
     */
    private static void placePolicy(JPanel panel) {
        // 当前策略
        JLabel userLabel = new JLabel("");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

    }

}
