package com.lele.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: lele
 * @date: 2023/6/5 16:06
 * @description: 字符串排序
 * 描述：给定 n 个字符串，请对 n 个字符串按照字典序排列。
 * 数据范围：1 <= n <= 1000,字符串长度满足 1 <= len <= 100
 * 示例：
 *  输入：9
 *       cap
 *       to
 *       cat
 *       card
 *       two
 *       too
 *       up
 *       boat
 *       boot
 *  输出：boat
 *       boot
 *       cap
 *       card
 *       cat
 *       to
 *       too
 *       two
 *       up
 *
 */

public class HJ14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String[] strArr = new String[len];
        for (int i = 0; i < len; i++) {
             strArr[i] = sc.next();
        }
        Arrays.sort(strArr);
        for (int j = 0; j < len; j++) {
            System.out.println(strArr[j]);
        }
    }
}
