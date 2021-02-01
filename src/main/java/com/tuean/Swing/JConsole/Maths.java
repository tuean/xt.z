package com.tuean.Swing.JConsole;

public class Maths {

    public static final double ROOT_TWO = (double)((float)Math.sqrt(2.0D));
    public static final double ROOT_THREE = (double)((float)Math.sqrt(3.0D));
    public static final double E = 2.718281828459045D;
    public static final double PI = 3.1415927410125732D;
    public static final double TWO_PI = 6.2831854820251465D;
    public static final double TAU = 6.2831854820251465D;
    public static final double HALF_PI = 1.5707963705062866D;
    public static final double QUARTER_PI = 0.7853981852531433D;
    private static final double EPSILON = 1.0E-5D;

    public Maths() {
    }

    public static float sqrt(float a) {
        return (float)Math.sqrt((double)a);
    }

    public static double sqrt(double a) {
        return Math.sqrt(a);
    }

    public static int clampToInteger(double value, int min, int max) {
        int v = (int)value;
        if (v < min) {
            return min;
        } else {
            return v > max ? max : v;
        }
    }

    public static int clampToInteger(float value, int min, int max) {
        int v = (int)value;
        if (v < min) {
            return min;
        } else {
            return v > max ? max : v;
        }
    }

    public static int middle(int a, int b, int c) {
        if (a < b) {
            if (b < c) {
                return b;
            } else {
                return a < c ? c : a;
            }
        } else if (a < c) {
            return a;
        } else {
            return b < c ? c : b;
        }
    }

    public static float middle(float a, float b, float c) {
        if (a < b) {
            if (b < c) {
                return b;
            } else {
                return a < c ? c : a;
            }
        } else if (a < c) {
            return a;
        } else {
            return b < c ? c : b;
        }
    }

    public static int sign(double a) {
        if (a == 0.0D) {
            return 0;
        } else {
            return a > 0.0D ? 1 : -1;
        }
    }

    public static int sign(float a) {
        if (a == 0.0F) {
            return 0;
        } else {
            return a > 0.0F ? 1 : -1;
        }
    }

    public static final int sign(int a) {
        return a == 0 ? 0 : (a > 0 ? 1 : -1);
    }

    public static final int sign2(int a) {
        return (a >> 31) + (a > 0 ? 1 : 0);
    }

    public static int sign(long a) {
        if (a == 0L) {
            return 0;
        } else {
            return a > 0L ? 1 : -1;
        }
    }

    public static int mod(int number, int divisor) {
        int r = number % divisor;
        if (r < 0) {
            r += divisor;
        }

        return r;
    }

    public static long quantize(long increase, long boundary, long base) {
        return (base + increase) / boundary - base / boundary;
    }

    public static double min(double a, double b, double c) {
        double result = a;
        if (b < a) {
            result = b;
        }

        if (c < result) {
            result = c;
        }

        return result;
    }

    public static double max(double a, double b, double c) {
        double result = a;
        if (b > a) {
            result = b;
        }

        if (c > result) {
            result = c;
        }

        return result;
    }

    public static float min(float a, float b, float c) {
        float result = a;
        if (b < a) {
            result = b;
        }

        if (c < result) {
            result = c;
        }

        return result;
    }

    public static float max(float a, float b, float c) {
        float result = a;
        if (b > a) {
            result = b;
        }

        if (c > result) {
            result = c;
        }

        return result;
    }

    public static final float min(float a, float b, float c, float d) {
        float result = a;
        if (a > b) {
            result = b;
        }

        if (result > c) {
            result = c;
        }

        if (result > d) {
            result = d;
        }

        return result;
    }

    public static final float max(float a, float b, float c, float d) {
        float result = a;
        if (a < b) {
            result = b;
        }

        if (result < c) {
            result = c;
        }

        if (result < d) {
            result = d;
        }

        return result;
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static float min(float a, float b) {
        return a < b ? a : b;
    }

    public static float max(float a, float b) {
        return a > b ? a : b;
    }

    public static int min(int a, int b, int c) {
        int result = a;
        if (b < a) {
            result = b;
        }

        if (c < result) {
            result = c;
        }

        return result;
    }

    public static int max(int a, int b, int c) {
        int result = a;
        if (b > a) {
            result = b;
        }

        if (c > result) {
            result = c;
        }

        return result;
    }

    public static float sigmoid(float a) {
        double ea = Math.exp((double)(-a));
        float df = (float)(1.0D / (1.0D + ea));
        if (Float.isNaN(df)) {
            return a > 0.0F ? 1.0F : 0.0F;
        } else {
            return df;
        }
    }

    public static double sigmoid(double a) {
        double ea = Math.exp(-a);
        double df = 1.0D / (1.0D + ea);
        if (Double.isNaN(df)) {
            return a > 0.0D ? 1.0D : 0.0D;
        } else {
            return df;
        }
    }

    public static double softplus(double a) {
        if (a > 100.0D) {
            return a;
        } else {
            return a < -100.0D ? 0.0D : Math.log(1.0D + Math.exp(a));
        }
    }

    public static float tanh(float a) {
        double ex = Math.exp((double)(2.0F * a));
        float df = (float)((ex - 1.0D) / (ex + 1.0D));
        if (Float.isNaN(df)) {
            return a > 0.0F ? 1.0F : -1.0F;
        } else {
            return df;
        }
    }

    public static double tanh(double a) {
        double ex = Math.exp(2.0D * a);
        double df = (ex - 1.0D) / (ex + 1.0D);
        if (Double.isNaN(df)) {
            return a > 0.0D ? 1.0D : -1.0D;
        } else {
            return df;
        }
    }

    public static double tanhScaled(double a) {
        return 1.7159D * tanh(0.6666666666666666D * a);
    }

    public static double tanhScaledDerivative(double a) {
        double ta = tanh(0.6666666666666666D * a);
        return 1.1439333333333332D * ta * (1.0D - ta);
    }

    public static float inverseSigmoid(float a) {
        if (a >= 1.0F) {
            return 800.0F;
        } else if (a <= 0.0F) {
            return -800.0F;
        } else {
            double ea = (double)a / (1.0D - (double)a);
            return (float)Math.log(ea);
        }
    }

    public static float sigmoidDerivative(float a) {
        float sa = sigmoid(a);
        return sa * (1.0F - sa);
    }

    public static float tanhDerivative(float a) {
        float sa = tanh(a);
        return 1.0F - sa * sa;
    }

    public static float frac(float a) {
        return a - (float)roundDown(a);
    }

    public static double frac(double a) {
        return a - Math.floor(a);
    }

    public static int square(byte b) {
        return b * b;
    }

    public static int square(int x) {
        return x * x;
    }

    public static float square(float x) {
        return x * x;
    }

    public static double square(double x) {
        return x * x;
    }

    public static int roundUp(double d) {
        int i = (int)d;
        return (double)i == d ? i : i + 1;
    }

    public static int roundUp(Number d) {
        return roundUp(d.doubleValue());
    }

    public static int roundUp(float d) {
        int i = (int)d;
        return (float)i == d ? i : i + 1;
    }

    public static int roundDown(double a) {
        if (a >= 0.0D) {
            return (int)a;
        } else {
            int x = (int)a;
            return a == (double)x ? x : x - 1;
        }
    }

    public static int roundDown(float a) {
        if (a >= 0.0F) {
            return (int)a;
        } else {
            int x = (int)a;
            return a == (float)x ? x : x - 1;
        }
    }

    public static double softMaximum(double x, double y) {
        double max = Math.max(x, y);
        double min = Math.min(x, y);
        return max + Math.log(1.0D + Math.exp(max - min));
    }

    public static final double bound(double v, double min, double max) {
        if (v < min) {
            return min;
        } else {
            return v > max ? max : v;
        }
    }

    public static final float bound(float v, float min, float max) {
        if (v < min) {
            return min;
        } else {
            return v > max ? max : v;
        }
    }

    public static final int bound(int v, int min, int max) {
        if (v < min) {
            return min;
        } else {
            return v > max ? max : v;
        }
    }

    public static boolean notNearZero(double d) {
        return d < -1.0E-5D || d > 1.0E-5D;
    }

    public static double mod(double num, double div) {
        double result = num % div;
        if (result < 0.0D) {
            result += div;
        }

        return result;
    }

    public static double triangleWave(double a) {
        a -= Math.floor(a);
        return a < 0.5D ? a * 2.0D : 2.0D - a * 2.0D;
    }

}
