package com.lele.msb.novice;

/**
 * @author: lele
 * @date: 2022/7/26 上午7:49
 * @description: 正整数1~N的阶乘之和
 */

public class SumOfFactorial {

    public static void main(String[] args) {
        int N = 5;
        System.out.println(factorial(N));
    }

    private static long factorial(int N) {
        long sum = 0;
        long cur = 1;

        for (int i = 1; i <= N; i++) {
            cur = cur * i;
            sum = sum + cur;
        }

        return sum;
    }
}
