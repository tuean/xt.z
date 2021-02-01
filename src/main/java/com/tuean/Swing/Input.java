package com.tuean.Swing;

import com.tuean.config.LoginConfig;
import com.tuean.consont.SystemParam;
import com.tuean.steps.Starter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 用戶输入控件
 */
public class Input {

    private static Logger logger = LoggerFactory.getLogger(Input.class);

    public static Integer x = 1340;
    public static Integer y = 1230;

    /**{
     * 创建并显示GUI。出于线程安全的考虑，
     * 这个方法在事件调用线程中调用。
     */
    public void createAndShowGUI() {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("用户输入：");
        //获取屏幕大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, x, y);
        JPanel login = new JPanel();
        // 添加登录面板
        frame.add(login);
        placeComponents(login);

        frame.setVisible(true);
    }

    /**
     * 登录部分
     * @param panel
     */
    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);
        // 标书号
        JLabel userLabel = new JLabel("输入验证码");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        // 创建登录按钮
        JButton loginButton = new JButton("出价");
        loginButton.setBounds(40, 140, 200, 25);

        panel.add(loginButton);
        loginButton.addActionListener(e -> {
            logger.info("当前用户输入：" + userText.getText());
        });
    }


}
