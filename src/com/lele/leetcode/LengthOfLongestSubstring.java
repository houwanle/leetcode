package com.lele.leetcode;

import java.util.HashMap;

/**
 * @author: lele
 * @date: 2021/3/8 07:23
 * @description: 无重复字符的最长子串
 * 描述：给定一个字符串s，请你找出其中不含有重复字符的 最长子串 的长度
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
//        String s = "asadsedrfd";
        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    private static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int num = 0, i = -1;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                i = Math.max(map.get(ch), i); // 更新左指针 i
            }

            num = Math.max(num, j-i);  // 更新结果
            map.put(ch, j);  // 哈希表记录
        }
        return num;
    }
}

