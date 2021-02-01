package com.tuean.Swing.JConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public final class BufferedImageIcon implements Icon {
    private final BufferedImage image;
    private final int x;
    private final int y;
    private final int w;
    private final int h;
    private final int dw;
    private final int dh;

    public BufferedImageIcon(BufferedImage b) {
        this(b, 0, 0, b.getWidth(), b.getHeight());
    }

    public BufferedImageIcon(BufferedImage b, int sx, int sy, int sw, int sh) {
        this.image = b;
        this.x = sx;
        this.y = sy;
        this.w = sw;
        this.h = sh;
        this.dw = sw;
        this.dh = sh;
    }

    public BufferedImageIcon(BufferedImage b, int sx, int sy, int sw, int sh, int destw, int desth) {
        this.image = b;
        this.x = sx;
        this.y = sy;
        this.w = sw;
        this.h = sh;
        this.dw = destw;
        this.dh = desth;
    }

    public void paintIcon(Component c, Graphics g, int dx, int dy) {
        g.drawImage(this.image, dx, dy, dx + this.dw, dy + this.dh, this.x, this.y, this.x + this.w, this.y + this.h, (ImageObserver)null);
    }

    public int getIconWidth() {
        return this.dw;
    }

    public int getIconHeight() {
        return this.dh;
    }
}
