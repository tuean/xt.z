package com.tuean.Swing.JConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JIcon extends JComponent {

    private static final long serialVersionUID = -8838960602578976244L;
    private Icon icon;
    private double xAlignment;
    private double yAlignment;

    public JIcon(BufferedImage b) {
        this((Icon)(new BufferedImageIcon(b)));
    }

    public JIcon(Icon icon) {
        this.icon = null;
        this.xAlignment = 0.5D;
        this.yAlignment = 0.5D;
        this.setIcon(icon);
    }

    public void paintComponent(Graphics g) {
        double x = (double)(this.getWidth() - this.icon.getIconWidth()) * this.xAlignment;
        double y = (double)(this.getHeight() - this.icon.getIconHeight()) * this.yAlignment;
        this.getIcon().paintIcon(this, g, (int)x, (int)y);
    }

    private void setIcon(Icon icon) {
        this.icon = icon;
        this.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
    }

    private Icon getIcon() {
        return this.icon;
    }

    public double getIconAlignmentX() {
        return this.xAlignment;
    }

    public void setIconAlignmentX(double xAlignment) {
        this.xAlignment = xAlignment;
    }

    public double getIconAlignmentY() {
        return this.yAlignment;
    }

    public void setIconAlignmentY(double yAlignment) {
        this.yAlignment = yAlignment;
    }

}
