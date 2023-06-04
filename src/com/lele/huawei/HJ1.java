package com.lele.huawei;

import java.util.Scanner;

/**
 * @author: lele
 * @date: 2023/6/4 09:06
 * @description: 字符串最后一个单词的长度
 * 描述：计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 *
 * 示例：
 *  输入：hello nowcoder
 *  输出：8
 *  说明：最后一个单词为nowcoder，长度为8
 */

public class HJ1 {

    public static void main(String[] args) {
        // 标准输入
        Scanner scanner = new Scanner(System.in);
        // 键盘输入字符串
        String s = scanner.nextLine();
        // 以空格分隔字符串数组
        String[] arr = s.split(" ");
        // 字符串数组最后一个元素即是原字符串的最后一个单词，直接输出其长度
        System.out.println(arr[arr.length - 1].length());
    }
}
