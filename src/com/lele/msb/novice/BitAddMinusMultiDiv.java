package com.lele.msb.novice;

/**
 * @author: lele
 * @date: 10/26/22 7:58 AM
 * @description:
 * 位运算：加、减、乘、除
 */

public class BitAddMinusMultiDiv {

    // 加法
    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            // 无进位相加
            sum = a ^ b;
            // 进位信息
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    // 取相反数 
    public static int negNum(int n) {
        return add(~n, 1);
    }

    // 减法
    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    // 乘法
    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1; // 无符号右移，支持负数
        }
        return res;
    }

    public static boolean isNeg(int n) {
        return n < 0;
    }

    // 除法，支持负数；系统最小值无法转成绝对值
    public static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 30; i >= 0; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    /**
     * 考虑系统最小值
     * @param a
     * @param b
     * @return
     */
    public static int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            if (b == negNum(1)) {
                return Integer.MAX_VALUE;
            } else {
                int c = div(add(a, 1), b);
                return add(c, div(minus(a, multi(c, b)), b));
            }
        } else {
            return div(a, b);
        }
    }

    public static void main(String[] args) {
        int a = 7;
        int b = -3;
        System.out.println(multi(a, b));
    }
}
