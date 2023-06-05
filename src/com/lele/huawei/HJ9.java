package com.lele.huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: lele
 * @date: 2023/6/5 14:52
 * @description: 提取不重复的整数
 * 描述：输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。保证输入的整数最后一位不是 0 。
 * 数据范围：1 <= n <= 10^8
 * 示例
 *  输入：9876673
 *  输出：37689
 */

public class HJ9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> hs = new HashSet<>();
        while (n != 0) {
            int temp = n % 10;
            if (hs.add(temp)) {
                System.out.print(temp);
            }
            n = n / 10;
        }
        System.out.println();
    }
}
