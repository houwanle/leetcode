package com.lele.msb;

/**
 * @author: lele
 * @date: 2022/7/25 上午7:00
 * @description: 打印十进制数的32位二进制信息
 *
 * 正数a的相反数：(~a + 1)
 */

public class PrintBinary {

    public static void main(String[] args) {
        int num = -2;

        print(num);
    }

    private static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
}
