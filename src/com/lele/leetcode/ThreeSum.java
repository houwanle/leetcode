package com.lele.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: lele
 * @date: 2021/5/25 16:57
 * @description: 三数之和
 */

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();

        int[] nums = {-1,0,1,2,-1,-4};

        System.out.println(threeSum.threeSum(nums));

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) {
            return resList;
        }

        //排序
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
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
