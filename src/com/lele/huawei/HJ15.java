package com.lele.huawei;

import java.util.Scanner;

/**
 * @author: lele
 * @date: 2023/6/5 16:25
 * @description: 求int型正整数在内存中存储时1的个数
 * 描述：输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
 * 数据范围：保证在 32 位整型数字范围内
 * 示例
 *  输入：5
 *  输出：2
 */

public class HJ15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;

        for (int i = 0; i < 32; i++) {
            if ((num & 1) == 1) {
                sum++;
            }
            num = num >>> 1;
        }
        System.out.println(sum);
    }
}
