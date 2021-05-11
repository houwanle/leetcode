package com.lele.leetcode.algorithms;

import java.util.HashMap;

/**
 * @author: lele
 * @date: 2021/3/8 07:23
 * @description: 无重复字符的最长子串
 */

public class LongestSubString {

    public static void main(String[] args) {
//        String s = "asadsedrfd";
        String s = "13212563";
        LongestSubString longestSubString = new LongestSubString();

        System.out.println(longestSubString.lengthOfLongestSubstring(s));
    }


    public int lengthOfLongestSubstring(String s) {
        HashMap<Object, Integer> map = new HashMap<>();
        int num = 0;
        for (int i = 0,j=0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                i = Math.max(map.get(ch), i);
            }

            num = Math.max(num, j-i+1);
            map.put(ch,j+1);
        }
        return num;
    }
}

