package com.lele.leetcode.algorithms;

/**
 * @author: lele
 * @date: 2023/5/23 18:34
 * @description: 删除字符串中的所有相邻重复项2
 *
 * 题目描述：
 * 给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。
 * 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
 * 在执行完所有删除操作后，返回最终得到的字符串。
 * 本题答案保证唯一。
 *
 * 初始长度为 n 的数组 counts。
 * 遍历字符串：
 *      如果当前字符与上一个字符相等，令 counts[i] = counts[i - 1] + 1
 *      否则，令 counts[i] = 1。
 *      如果 counts[i] = k，删除这 k 个字符，令 i = i - k。
 */

public class RemoveDuplicates {

    public static void main(String[] args) {
        String s = "pbbcggttciiippooaais";
        int k = 2;
        System.out.println(removeDuplicates(s, k));
    }

    public static String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int[] counts = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                counts[i] = 1;
            } else {
                counts[i] = counts[i - 1] + 1;
                if (counts[i] == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                }
            }
        }
        return sb.toString();
    }
}
