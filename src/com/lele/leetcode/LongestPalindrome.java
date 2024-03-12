package com.lele.leetcode;

/**
 * @author: lele
 * @date: 2021/5/11 19:22
 * @description: 最长回文子串
 */

public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String str = "bbbscsb";

        System.out.println(longestPalindrome.longestPalindrome(str));
    }

    // 遍历所有长度大于2的子串
    public String longestPalindrome(String str) {
        int len = str.length();
        if (len < 2) {
            return str;
        }

        int maxLen = 1;
        String result = str.substring(0, 1);

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (maxLen < j - i + 1 && valid(str, i, j)) {
                    maxLen = j - i + 1;
                    // 截取[i,j]
                    result = str.substring(i, j + 1);
                }
            }
        }
        return result;
    }

    public boolean valid(String str, int left, int right) {
        // 判断子串 [left,right]是否为回文字符串
        while(left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
