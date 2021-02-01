package com.tuean.Swing.JConsole;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public final class Rand {

    private static volatile long state = xorShift64(System.nanoTime() | -889275714L);
    private static final double DOUBLE_SCALE_FACTOR = 1.0D / Math.pow(2.0D, 63.0D);
    private static final float FLOAT_SCALE_FACTOR = (float)(1.0D / Math.pow(2.0D, 63.0D));

    public Rand() {
    }

    public static final long nextLong() {
        long a = state;
        state = xorShift64(a);
        return a;
    }

    public static final long xorShift64(long a) {
        a ^= a << 21;
        a ^= a >>> 35;
        a ^= a << 4;
        return a;
    }

    public static final int xorShift32(int a) {
        a ^= a << 13;
        a ^= a >>> 17;
        a ^= a << 5;
        return a;
    }

    public static boolean chance(double d) {
        return nextDouble() < d;
    }

    public static boolean chance(float d) {
        return nextFloat() < d;
    }

    public static int best(int r, int n, int s) {
        if (n > 0 && r >= 0 && r <= n && s >= 0) {
            int[] rolls = new int[n];

            for(int i = 0; i < n; ++i) {
                rolls[i] = d(s);
            }

            int sum;
            int i;
            boolean found;
            do {
                found = false;

                for(sum = 0; sum < n - 1; ++sum) {
                    if (rolls[sum] < rolls[sum + 1]) {
                        i = rolls[sum];
                        rolls[sum] = rolls[sum + 1];
                        rolls[sum + 1] = i;
                        found = true;
                    }
                }
            } while(found);

            sum = 0;

            for(i = 0; i < r; ++i) {
                sum += rolls[i];
            }

            return sum;
        } else {
            return 0;
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

    public static int sig(float x) {
        return chance(sigmoid((double)x)) ? 1 : 0;
    }

    public static int po(double mean) {
        if (mean <= 0.0D) {
            if (mean < 0.0D) {
                throw new IllegalArgumentException();
            } else {
                return 0;
            }
        } else {
            return mean > 400.0D ? poLarge(mean) : poMedium(mean);
        }
    }

    private static int poMedium(double mean) {
        int r = 0;
        double a = nextDouble();

        for(double p = Math.exp(-mean); a > p; p = p * mean / (double)r) {
            ++r;
            a -= p;
        }

        return r;
    }

    private static int poLarge(double mean) {
        return (int)(0.5D + n(mean, Math.sqrt(mean)));
    }

    public static int po(int numerator, int denominator) {
        return po((double)numerator / (double)denominator);
    }

    public static int d(int number, int sides) {
        int total = 0;

        for(int i = 0; i < number; ++i) {
            total += d(sides);
        }

        return total;
    }

    public static double factorial(int n) {
        if (n < 2) {
            return 1.0D;
        } else {
            double result = 1.0D;

            for(int i = 2; i <= n; ++i) {
                result *= (double)i;
            }

            return result;
        }
    }

    public static double factorialRatio(int n, int r) {
        if (n < 2) {
            return 1.0D;
        } else if (n < r) {
            return 1.0D / factorialRatio(r, n);
        } else {
            double result = 1.0D;

            for(int i = r + 1; i <= n; ++i) {
                result *= (double)i;
            }

            return result;
        }
    }

    public static double cumulativeBinomialChance(int r, int n, double p) {
        double prob = 0.0D;

        for(int i = 0; i <= r; ++i) {
            prob += binomialChance(i, n, p);
        }

        return prob;
    }

    public static double combinations(int r, int n) {
        return r > n - r ? combinations(n - r, n) : factorialRatio(n, n - r) / factorial(r);
    }

    public static double binomialChance(int r, int n, double p) {
        return combinations(r, n) * Math.pow(p, (double)r) * Math.pow(1.0D - p, (double)(n - r));
    }

    public static double exp(double mean) {
        return -Math.log(nextDouble()) * mean;
    }

    public static int geom(double p) {
        return (int)Math.floor(Math.log(nextDouble()) / Math.log(1.0D - p));
    }

    public static final int nextInt() {
        return (int)(nextLong() >> 32);
    }

    public static final short nextShort() {
        return (short)((int)(nextLong() >> 32));
    }

    public static final char nextChar() {
        return (char)((int)(nextLong() >> 32));
    }

    public static final String nextLetterString(int length) {
        char[] cs = new char[length];

        for(int i = 0; i < length; ++i) {
            cs[i] = nextLetter();
        }

        return new String(cs);
    }

    public static final byte nextByte() {
        return (byte)((int)(nextLong() >> 32));
    }

    public static boolean nextBoolean() {
        return (nextLong() & 65536L) != 0L;
    }

    public static final char nextLetter() {
        return (char)range(97, 122);
    }

    public static final int r(int s) {
        if (s < 0) {
            throw new IllegalArgumentException();
        } else {
            long result = (nextLong() >>> 32) * (long)s >> 32;
            return (int)result;
        }
    }

    public static final int otherIndex(int i, int max) {
        return (r(max - 1) + i) % max;
    }

    public static final double nextDouble() {
        return (double)(nextLong() >>> 1) * DOUBLE_SCALE_FACTOR;
    }

    public static final float nextFloat() {
        return (float)(nextLong() >>> 1) * FLOAT_SCALE_FACTOR;
    }

    public static final double u() {
        return nextDouble();
    }

    public static final double u(double max) {
        return u(0.0D, max);
    }

    public static final double u(double min, double max) {
        return min + nextDouble() * (max - min);
    }

    public static final int round(double d) {
        int i = (int)Math.floor(d);
        int rem = nextDouble() < d - (double)i ? 1 : 0;
        return i + rem;
    }

    public static final int range(int n1, int n2) {
        if (n1 > n2) {
            int t = n1;
            n1 = n2;
            n2 = t;
        }

        return n1 + r(n2 - n1 + 1);
    }

    public static final int d(int sides) {
        return r(sides) + 1;
    }

    public static final int d3() {
        return d(3);
    }

    public static final int d4() {
        return d(4);
    }

    public static final int d6() {
        return d(6);
    }

    public static final int d8() {
        return d(8);
    }

    public static final int d10() {
        return d(10);
    }

    public static final int d12() {
        return d(12);
    }

    public static final int d20() {
        return d(20);
    }

    public static final int d100() {
        return d(100);
    }

    public static double n(double u, double sd) {
        return nextGaussian() * sd + u;
    }

    public static double nextGaussian() {
        double x;
        double d2;
        do {
            x = 2.0D * nextDouble() - 1.0D;
            double y = 2.0D * nextDouble() - 1.0D;
            d2 = x * x + y * y;
        } while(d2 > 1.0D || d2 == 0.0D);

        double radiusFactor = Math.sqrt(-2.0D * Math.log(d2) / d2);
        return x * radiusFactor;
    }

    public static String nextString() {
        char[] cs = new char[po(4.0D)];

        for(int i = 0; i < cs.length; ++i) {
            cs[i] = nextLetter();
        }

        return String.valueOf(cs);
    }

    public static <T> void shuffle(T[] ts) {
        for(int i = 0; i < ts.length - 1; ++i) {
            int j = r(ts.length - i);
            if (i != j) {
                T t = ts[i];
                ts[i] = ts[j];
                ts[j] = t;
            }
        }

    }

    public static void chooseIntegers(int[] dest, int destOffset, int length, int maxValue) {
        if (length > maxValue) {
            throw new Error("Cannot choose " + length + " items from a set of " + maxValue);
        } else if (maxValue > 4 * length) {
            chooseIntegersBySampling(dest, destOffset, length, maxValue);
        } else {
            chooseIntegersByExclusion(dest, destOffset, length, maxValue);
        }
    }

    public static void randIntegers(int[] dest, int destOffset, int length, int maxValue) {
        for(int i = destOffset; i < destOffset + length; ++i) {
            dest[i] = r(maxValue);
        }

    }

    private static void chooseIntegersByExclusion(int[] dest, int destOffset, int n, int maxValue) {
        for(; n > 0; --maxValue) {
            if (n == maxValue || r(maxValue) < n) {
                dest[destOffset + n - 1] = maxValue - 1;
                --n;
            }
        }

    }

    private static void chooseIntegersByReservoirSampling(int[] dest, int destOffset, int n, int maxValue) {
        int found = 0;

        for(int i = 0; i < maxValue; ++i) {
            if (found < n) {
                dest[destOffset + found] = i;
                ++found;
            } else {
                int ni = r(i + 1);
                if (ni < n) {
                    dest[destOffset + ni] = i;
                }
            }
        }

    }

    private static void chooseIntegersBySampling(int[] dest, int destOffset, int n, int maxValue) {
        TreeSet s = new TreeSet();

        while(s.size() < n) {
            int v = r(maxValue);
            s.add(v);
        }

        Integer i;
        for(Iterator i$ = s.iterator(); i$.hasNext(); dest[destOffset++] = i) {
            i = (Integer)i$.next();
        }

    }

    public static <T> T pick(T[] ts) {
        return ts[r(ts.length)];
    }

    public static <T> T pick(List<T> ts) {
        return ts.get(r(ts.size()));
    }

    public static void fillUniform(float[] d, int start, int length) {
        for(int i = 0; i < length; ++i) {
            d[start + i] = nextFloat();
        }

    }

    public static void fillBinary(float[] d, int start, int length) {
        for(int i = 0; i < length; ++i) {
            d[start + i] = (float)r(2);
        }

    }

    public static void fillGaussian(float[] d, int start, int length, float u, float sd) {
        for(int i = 0; i < length; ++i) {
            d[start + i] = (float)n((double)u, (double)sd);
        }

    }

    public static void fillGaussian(double[] d, int start, int length, double u, double sd) {
        for(int i = 0; i < length; ++i) {
            d[start + i] = n(u, sd);
        }

    }

    public static void fillBinary(double[] data, int start, int length, double mean) {
        for(int i = 0; i < length; ++i) {
            data[start + i] = binary(mean);
        }

    }

    public static double binary(double mean) {
        return nextDouble() < mean ? 1.0D : 0.0D;
    }

    public static void binarySample(float[] temp, int offset, int length) {
        for(int i = offset; i < offset + length; ++i) {
            temp[i] = nextFloat() < temp[i] ? 1.0F : 0.0F;
        }

    }

    public static void binarySample(double[] temp, int offset, int length) {
        for(int i = offset; i < offset + length; ++i) {
            temp[i] = nextDouble() < temp[i] ? 1.0D : 0.0D;
        }

    }

    public static int indexFromWeights(double[] probabilities) {
        double total = 0.0D;

        for(int i = 0; i < probabilities.length; ++i) {
            total += probabilities[i];
        }

        double position = total * nextDouble();

        for(int i = 0; i < probabilities.length; ++i) {
            position -= probabilities[i];
            if (position <= 0.0D) {
                return i;
            }
        }

        throw new Error("Funny probabilities array!");
    }

}
