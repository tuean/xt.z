package com.tuean.Swing;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class Console {

    int x = 200;
    int y = 0;

    final JFrame frame = new JFrame();
    public Console() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, x, y);
        JTextArea textArea = new JTextArea(24, 80);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.LIGHT_GRAY);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                textArea.append(String.valueOf((char) b));
            }
        }));
        frame.add(textArea);
    }
    public void init() {
        frame.pack();
        frame.setVisible(true);
    }
    public JFrame getFrame() {
        return frame;
    }

}
