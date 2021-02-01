package com.tuean.Swing.JConsole;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.net.URL;

public class ImageUtils {
    public ImageUtils() {
    }

    public static BufferedImage loadImage(String filename) {
        try {
            URL imageURL = Thread.currentThread().getContextClassLoader().getResource(filename);
            return ImageIO.read(imageURL);
        } catch (Exception var3) {
            throw new RuntimeException(var3);
        }
    }

    public static BufferedImage newImage(int w, int h) {
        BufferedImage result = new BufferedImage(w, h, 2);
        return result;
    }

    public static BufferedImage loadImage(URL imageURL) {
        try {
            BufferedImage image = ImageIO.read(imageURL);
            return image;
        } catch (IOException var3) {
            throw new Error("Image read failed", var3);
        }
    }

    public static int randomColour() {
        return Colours.randomARGBColour();
    }

    public static BufferedImage scaleImage(BufferedImage img, int w, int h) {
        BufferedImage result = new BufferedImage(w, h, 2);
        Graphics2D g = (Graphics2D)result.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, w, h, (ImageObserver)null);
        return result;
    }

    public static Frame display(BufferedImage image) {
        return Frames.display(new JIcon(image));
    }

    public static Frame display(BufferedImage image, String s) {
        return Frames.display(new JIcon(image), s);
    }
}
