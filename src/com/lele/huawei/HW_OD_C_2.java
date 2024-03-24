package com.lele.huawei;

import java.util.Scanner;

/**
 * @author: lele
 * @date: 2024/3/23 09:44
 * @description:
 * 描述：输入字符串s，输出s中包含所有整数的最小和
 * 说明：
 * 1.字符串s，只包含a-z,A-Z,+,-;
 * 2.合法的整数包括
 *      a.正整数，一个或多个0-9组成，例如 0 2 3 002 102
 *      b.负整数，负号 - 开头，数字部分由一个或者多个0-9组成，如 -0 -012 -23 -00023
 * 示例：
 * 输入：
 * bb12-34aa
 * 输出：
 * -31
 */

public class HW_OD_C_2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(func(str));
    }

    public static int function(String str) {
        int res = 0;

        str = str.replaceAll("[a-zA-Z]", "");

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '-' || str.charAt(i) != '+') {
                res = res + Integer.parseInt(str.substring(i, i+1));
            }

            if (str.charAt(i) == '-') {
                res = res - Integer.parseInt(str.substring(i+1, str.length()));
            }
        }

        return res;
    }

    public static int func(String str) {
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                res = res + Integer.parseInt(str.charAt(i) + "");
            }else if (str.charAt(i) == '-') {
                int startIndex = i;
                do {
                    i++;
                }while(i < str.length() && Character.isDigit(str.charAt(i)));
                if (startIndex < i-1) {
                    res -= Integer.parseInt(str.substring(startIndex + 1, i) + "");
                }
            }
        }

        return res;
    }
}
