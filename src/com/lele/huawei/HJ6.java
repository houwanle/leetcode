package com.lele.huawei;

import java.util.Scanner;

/**
 * @author: lele
 * @date: 2023/6/4 18:34
 * @description: 质数因子
 * 描述：输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * 示例
 *  输入：180
 *  输出：2 2 3 3 5
 */

public class HJ6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = (long) Math.sqrt(n);

        for (long i = 2; i <= k; i++) {
            while (n % i == 0) {
                System.out.print(i + " ");
                n = n / i;
            }
        }
        System.out.println(n == 1 ? "" : n + " ");
    }
}
