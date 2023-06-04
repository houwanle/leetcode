package com.lele.huawei;

import java.util.Scanner;

/**
 * @author: lele
 * @date: 2023/6/4 09:53
 * @description: 字符串分隔
 * 描述：输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 *      长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 示例：
 *  输入：abc
 *  输出：abc00000
 */

public class HJ4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            int size = str.length();
            int addZero = 8 - size % 8; // addZero可能等于8
            while (addZero > 0  && addZero < 8) { //注意边界调节，避免addZero=8
                sb.append("0");
                addZero--;
            }

            String str1 = sb.toString();
            while(str1.length() > 0) {
                System.out.println(str1.substring(0, 8));
                str1 = str1.substring(8);
            }

        }
    }
}
