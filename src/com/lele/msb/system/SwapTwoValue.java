package com.lele.msb.system;

/**
 * @author: lele
 * @date: 2023/2/23 08:20
 * @description: 不使用额外的变量交换两个变量的值
 *
 * 0 ^ N = N
 * N ^ N = 0
 * a ^ b ^ c = c ^ b ^ a
 */

public class SwapTwoValue {

    public static void main(String[] args) {
        int a = 6;
        int b = 7;

        System.out.println("交换前：a = " + a);
        System.out.println("交换前：b = " + b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("交换后：a = " + a);
        System.out.println("交换后：b = " + b);

        int[] arr = {3, 1, 100};

        System.out.println("交换前：arr[0] = "+ arr[0]);
        System.out.println("交换前：arr[1] = "+ arr[1]);

        swap(arr, 0, 1);

        System.out.println("交换后：arr[0] = "+ arr[0]);
        System.out.println("交换后：arr[1] = "+ arr[1]);
    }

    // i 和 j 是一个位置的话，会出错
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
