package com.lele.huawei;

import java.util.Scanner;

/**
 * @author: lele
 * @date: 2023/6/4 13:46
 * @description: 进制转换
 * 描述：写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。1 <= n <= 2^31 -1
 * 示例：
 *  输入：0xAA
 *  输出：170
 */

public class HJ5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(Integer.parseInt(s.substring(2, s.length()), 16));
        }
    }
}
