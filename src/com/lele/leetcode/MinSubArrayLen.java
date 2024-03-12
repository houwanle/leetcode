package com.lele.leetcode;

/**
 * @author: lele
 * @date: 2023/5/22 18:07
 * @description: 长度最小的子数组
 */

public class MinSubArrayLen {

    public static void main(String[] args) {
        int target = 7;
        int[] arr = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target, arr));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;

        while(right < len) {
            sum = sum + nums[right];
            while(sum >= target) {
                // 避免越界
                ans = Math.min(ans, right - left + 1);
                // 从sum中减掉左指针指向的数
                sum = sum - nums[left];
                // 左指针往右移
                left++;
            }
            // 右指针往右移
            right++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
