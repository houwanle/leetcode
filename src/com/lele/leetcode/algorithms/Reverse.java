package com.lele.leetcode.algorithms;

/**
 * @author: lele
 * @date: 2021/5/20 16:06
 * @description: 整数反转
 */

public class Reverse {

    public static void main(String[] args) {
        Reverse reverse = new Reverse();

        System.out.println(reverse.reverse(4567));
    }

    public int reverse(int x) {
        if (x < Math.pow(-2, 31) || x > Math.pow(2, 31) - 1) {
            return 0;
        }

        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }

        return (int)n == n ? (int)n : 0;
    }
}
