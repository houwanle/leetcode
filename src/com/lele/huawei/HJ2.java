package com.lele.huawei;

import java.util.Scanner;

/**
 * @author: lele
 * @date: 2023/6/4 09:28
 * @description: 计算某字符串出现次数
 * 描述：写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 * 示例：
 *  输入：ABCabc
 *       A
 *  输出：2
 */

public class HJ2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine().toLowerCase();
        String str2 = sc.nextLine().toLowerCase();

        System.out.println(str1.length() - str1.replaceAll(str2, "").length());
    }
}
