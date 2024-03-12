package com.lele.leetcode;

/**
 * @author: lele
 * @date: 2021/5/21 19:11
 * @description: 字符串转整数
 */

public class MyAtoi {
    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();

        String s = "2147483647";
        System.out.println(myAtoi.myAtoi(s));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
    }

    public int myAtoi (String s) {
        s = s.trim();
        if (s.equals("")) {
            return 0;
        }

        char[] ch = s.toCharArray();
        long sum = 0;
        int flag = 1;

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '-' && i == 0) {
                flag = -1;
                continue;
            }
            if (ch[i] == '+' && i == 0) {
                flag = 1;
                continue;
            }

            if (ch[i] >= '0' && ch[i] <= '9') {
                sum = (ch[i] - '0') + sum * 10;
            } else {
                break;
            }

            if (ch[0] == '-' && -sum <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (ch[0] != '-' && sum >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return (int)sum * flag;
    }
}
