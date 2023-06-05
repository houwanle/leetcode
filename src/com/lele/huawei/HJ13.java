package com.lele.huawei;

import java.util.Scanner;

/**
 * @author: lele
 * @date: 2023/6/5 15:48
 * @description: 句子逆序
 * 描述：将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 *      所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 * 数据范围：输入的字符串长度满足 1 <= n <= 1000
 * 示例：
 *  输入：I am a boy
 *  输出：boy a am I
 */

public class HJ13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArr = str.split(" ");

        for (int i = strArr.length - 1; i >= 0; i--) {
            if (i != 0) {
                System.out.print(strArr[i] + " ");
            } else {
                System.out.print(strArr[i]);
            }
        }
    }
}
