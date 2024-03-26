package com.lele.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: lele
 * @date: 2024/3/26 12:01
 * @description: 最长连续序列
 * 描述：给定一个未排序的整数数组nums，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。时间复杂度为 o(n)
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */

public class LongestConsecutive {

    public static void main(String[] args) {

        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }


    private static int longestConsecutive(int[] nums) {
        int res = 0; //记录最长连续序列长度
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int seqLen;
        for (int num : set) {
            // 如果当前的数是一个连续序列的起点，统计这个连续序列的长度
            if (!set.contains(num - 1)) {
                seqLen = 1;

                while(set.contains(++num)) {// 不断查找连续序列，直到num的下一个数不存在于数组中
                    seqLen++;
                }
                res = Math.max(res, seqLen);// 更新最长连续序列长度
            }
        }

        return res;
    }
}
