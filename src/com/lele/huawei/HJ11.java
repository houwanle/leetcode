package com.lele.huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: lele
 * @date: 2023/6/5 15:27
 * @description: 数字颠倒
 * 描述：输入一个整数，将这个整数以字符串的形式逆序输出
 *      程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 * 数据范围：0 <= n <= 2^30 -1
 * 示例
 *  输入：1516000
 *  输出：0006151
 */

public class HJ11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
