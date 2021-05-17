package com.lele.math;

/**
 * @author: lele
 * @date: 2021/5/17 20:36
 * @description:
 */

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int n = 6;
        System.out.println(fibonacci.getFib3(n));
    }

    /**
     * 斐波拉契数列----递归实现
     * @param n
     * @return
     */
    public int getFib1(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return getFib1(n - 1) + getFib1(n - 2);
        }
    }

    /**
     * 斐波拉契数列----数组实现
     * @param n
     * @return
     */
    public int getFib2(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            int[] arr = new int[n+1];
            arr[0] = 0;
            arr[1] = arr[2] = 1;
            for (int i = 3; i <= n; i++) {
                arr[i] = arr[i-1] + arr[i-2];
            }
            return arr[n];
        }
    }

    /**
     * 斐波拉契数列----变量实现
     * @param n
     * @return
     */
    public int getFib3(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            int c = 0, a = 1, b = 1;
            for (int i = 3; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }
}
