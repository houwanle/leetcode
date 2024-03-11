package com.lele.huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: lele
 * @date: 2023/6/5 15:10
 * @description: 字符个数统计
 * 描述：编写一个函数，计算字符串中含有的不同字符的个数。字符在 ASCII 码范围内( 0~127 ，包括 0 和 127 )，
 *      换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 数据范围：1 <= n <= 500
 * 示例
 *  输入：aac
 *  输出：2
 */

public class HJ10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashSet<Character> hs = new HashSet<>(str.length());

        // 过滤掉输入的字符串中 非字母 的字符
        str = keepLettersOnly(str);

        for (int i = 0; i < str.length(); i++) {
            hs.add(str.charAt(i));
        }
        System.out.println(hs.size());
    }

    /**
     * 仅保留输入字符串中的 字母
     * @param str  输入的字符串
     * @return  仅含字母的字符串
     */
    private static String keepLettersOnly(String str) {
        return str.replaceAll("[^a-zA-Z]", "");
    }
}
