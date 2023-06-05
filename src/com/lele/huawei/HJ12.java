package com.lele.huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: lele
 * @date: 2023/6/5 15:41
 * @description: 字符串反转
 * 描述：接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * 示例：
 *  输入：abcd
 *  输出：dcba
 */

public class HJ12 {
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
