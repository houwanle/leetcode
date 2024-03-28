package com.lele.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: lele
 * @date: 2021/5/25 16:57
 * @description: 三数之和
 * 描述：给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */

public class ThreeSum {

    public static void main(String[] args) {

        int[] nums = {-1,0,1,2,-1,-4};

        System.out.println(threeSum(nums));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) {
            return resList;
        }

        //排序
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            }

            if (i > 0 && nums[i] == nums[i-1]) {
                continue;//去重
            }

            int L = i + 1;
            int R = len - 1;
            while(L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    resList.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while(L < R && nums[L] == nums[L + 1]) {
                        L++;//去重
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;// 去重
                    }

                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0){
                    R--;
                }
            }
        }
        return resList;
    }
}
