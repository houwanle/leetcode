package com.lele.leetcode;

/**
 * @author: lele
 * @date: 2024/3/28 18:18
 * @description: 接雨水
 * 描述：给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 */

public class Trap {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(height));
    }

    /**
     * 动态规划
     * @param height
     * @return
     */
    private static int trap(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i+1], height[i+1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if(min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }
    
}
