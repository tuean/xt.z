package com.tuean.Swing.JConsole;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Frames {

    private static final HashMap<String, JFrame> frames = new HashMap();

    public Frames() {
    }

    public static JFrame createFrame(String title) {
        JFrame f = (JFrame)frames.get(title);
        if (f == null) {
            f = new JFrame(title);
            frames.put(title, f);
            f.setVisible(true);
            f.pack();
            f.setDefaultCloseOperation(2);
        } else {
            f.getContentPane().removeAll();
            if (!f.isVisible()) {
                f.setVisible(true);
            } else {
                f.validate();
            }

            f.repaint();
        }

        f.setDefaultCloseOperation(2);
        return f;
    }

    public static JFrame createImageFrame(final BufferedImage image, String title) {
        final JFrame f = createFrame(title);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        JMenuItem jmi = new JMenuItem("Save As...");
        menu.add(jmi);
        jmi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                FileDialog fileDialog = new FileDialog(f, "Save Image As...", 1);
                fileDialog.setFile("*.png");
                fileDialog.setVisible(true);
                String fileName = fileDialog.getFile();
                if (fileName != null) {
                    File outputFile = new File(fileDialog.getDirectory(), fileName);

                    try {
                        ImageIO.write(image, "png", outputFile);
                        System.out.println("Saving: " + outputFile.getAbsolutePath());
                    } catch (IOException var6) {
                        var6.printStackTrace();
                    }
                }

            }
        });
        JComponent c = new JIcon(image);
        c.setMinimumSize(new Dimension(image.getWidth((ImageObserver)null), image.getHeight((ImageObserver)null)));
        f.setMinimumSize(new Dimension(image.getWidth((ImageObserver)null) + 20, image.getHeight((ImageObserver)null) + 100));
        f.add(c);
        f.setJMenuBar(menuBar);
        f.setDefaultCloseOperation(2);
        f.pack();
        return f;
    }

    public static JFrame display(BufferedImage image, String title) {
        return displayImage(image, title);
    }

    public static JFrame displayImage(BufferedImage image, String title) {
        JFrame f = createImageFrame(image, title);
        return f;
    }

    public static void showFrame(JFrame f) {
        if (!f.isVisible()) {
            f.setVisible(true);
        }

        f.pack();
    }

    public static JFrame display(JComponent component) {
        JFrame f = createFrame("View Popup");
        f.getContentPane().add(component);
        showFrame(f);
        return f;
    }

    public static JFrame display(JComponent component, String title) {
        JFrame f = createFrame(title);
        f.getContentPane().add(component);
        showFrame(f);
        return f;
    }

    public static void main(String[] args) {
        display((JComponent)(new JButton("Hello!")), "Test Frame");
        display((JComponent)(new JButton("Hello Two!")), "Test Frame");
        displayImage(ImageUtils.newImage(200, 200), "Test Image Frame");
    }
}
