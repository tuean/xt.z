package com.tuean.Swing.JConsole;

import java.awt.*;

public class Colours {

    public static int RGB_MASK = 16777215;
    public static int RED_MASK = 16711680;
    public static int GREEN_MASK = 65280;
    public static int BLUE_MASK = 255;
    public static int ALPHA_MASK = -16777216;
    public static final int BYTE_MASK = 255;
    private static final int MAX_BYTE = 255;
    private static final float INVERSE_FLOAT_FACTOR = 0.003921569F;

    public Colours() {
    }

    public static int getRed(int argb) {
        return argb >> 16 & 255;
    }

    public static int getGreen(int argb) {
        return argb >> 8 & 255;
    }

    public static int getBlue(int argb) {
        return argb & 255;
    }

    public static int getAlpha(int argb) {
        return argb >> 24 & 255;
    }

    public static int toGreyScale(int argb) {
        int lum = getLuminance(argb);
        return argb & ALPHA_MASK | 65793 * lum;
    }

    public static int getLuminance(int argb) {
        int lum = 77 * (argb >> 16 & 255) + 150 * (argb >> 8 & 255) + 29 * (argb & 255) >> 8;
        return lum;
    }

    public static int getARGBClamped(double r, double g, double b, double a) {
        int ri = Maths.clampToInteger(r * 255.0D, 0, 255);
        int gi = Maths.clampToInteger(g * 255.0D, 0, 255);
        int bi = Maths.clampToInteger(b * 255.0D, 0, 255);
        int ai = Maths.clampToInteger(a * 255.0D, 0, 255);
        return getARGBQuick(ri, gi, bi, ai);
    }

    public static int getARGBClamped(float r, float g, float b, float a) {
        int ri = Maths.clampToInteger(r * 255.0F, 0, 255);
        int gi = Maths.clampToInteger(g * 255.0F, 0, 255);
        int bi = Maths.clampToInteger(b * 255.0F, 0, 255);
        int ai = Maths.clampToInteger(a * 255.0F, 0, 255);
        return getARGBQuick(ri, gi, bi, ai);
    }

    public static int getRGBClamped(float r, float g, float b) {
        int ri = Maths.clampToInteger(r * 255.0F, 0, 255);
        int gi = Maths.clampToInteger(g * 255.0F, 0, 255);
        int bi = Maths.clampToInteger(b * 255.0F, 0, 255);
        return getRGBQuick(ri, gi, bi);
    }

    public static int getRGBClamped(double r, double g, double b) {
        int ri = Maths.clampToInteger(r * 255.0D, 0, 255);
        int gi = Maths.clampToInteger(g * 255.0D, 0, 255);
        int bi = Maths.clampToInteger(b * 255.0D, 0, 255);
        return getRGBQuick(ri, gi, bi);
    }

    public static int getARGBClamped(int r, int g, int b, int a) {
        int ri = Maths.bound(r, 0, 255);
        int gi = Maths.bound(g, 0, 255);
        int bi = Maths.bound(b, 0, 255);
        int ai = Maths.bound(a, 0, 255);
        return getARGBQuick(ri, gi, bi, ai);
    }

    public static void toFloat4(float[] col, int offset, int argb) {
        col[offset] = (float)getRed(argb) * 0.003921569F;
        col[offset + 1] = (float)getGreen(argb) * 0.003921569F;
        col[offset + 2] = (float)getBlue(argb) * 0.003921569F;
        col[offset + 3] = (float)getAlpha(argb) * 0.003921569F;
    }

    public static int fromFloat4(float[] col, int offset) {
        return getARGBClamped(col[offset], col[offset + 1], col[offset + 2], col[offset + 3]);
    }

    public static int fromDouble3(double[] col, int offset) {
        return getRGBClamped(col[offset], col[offset + 1], col[offset + 2]);
    }

    public static int fromFloat3(float[] col, int offset) {
        return getRGBClamped(col[offset], col[offset + 1], col[offset + 2]);
    }

    public static int getARGB(int r, int g, int b, int a) {
        return getARGBQuick(r & 255, g & 255, b & 255, a & 255);
    }

    public static int getARGB(int r, int g, int b) {
        return getARGBQuick(r & 255, g & 255, b & 255, 255);
    }

    public static int getARGB(int rgb, int alpha) {
        return rgb & RGB_MASK | (alpha & 255) << 24;
    }

    static int getARGBQuick(int r, int g, int b, int a) {
        return a << 24 | r << 16 | g << 8 | b;
    }

    static int getRGBQuick(int r, int g, int b) {
        return ALPHA_MASK | r << 16 | g << 8 | b;
    }

    public Color getRGBColor(int rgb) {
        int r = getRed(rgb);
        int g = getGreen(rgb);
        int b = getBlue(rgb);
        return new Color(r, g, b);
    }

    public static Color getColor(int argb) {
        int r = getRed(argb);
        int g = getGreen(argb);
        int b = getBlue(argb);
        int a = getAlpha(argb);
        return new Color(r, g, b, a);
    }

    public static int randomARGBColour() {
        return -16777216 + 65536 * Rand.r(256) + 256 * Rand.r(256) + Rand.r(256);
    }

    public static Color getColor(int r, int g, int b) {
        return new Color(r, g, b);
    }

    public static int toGreyScale(float f) {
        return -16777216 | 65793 * floatToByte(f);
    }

    public static int toGreyScale(double d) {
        return -16777216 | 65793 * doubleToByte(d);
    }

    public static int toGreen(float f) {
        return -16777216 | 256 * floatToByte(f);
    }

    private static int floatToByte(float f) {
        return Maths.bound((int)(f * 255.0F), 0, 255);
    }

    private static int doubleToByte(double d) {
        return Maths.bound((int)(d * 255.0D), 0, 255);
    }

}
