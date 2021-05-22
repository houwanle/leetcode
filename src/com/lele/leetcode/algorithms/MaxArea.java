package com.lele.leetcode.algorithms;

/**
 * @author: lele
 * @date: 2021/5/22 08:24
 * @description: 盛最多水的容器
 */

public class MaxArea {
    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();

        int[] arr = {4,3,2,1,4};

        System.out.println(maxArea.maxArea(arr));
    }


    public int maxArea (int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0, j = arr.length - 1; i < j;) {
//            int minHeight = arr[i] < arr[j] ? arr[i++] : arr [j--];

            int minHeight = -1;
            if (arr[i] < arr[j]) {
                minHeight = arr[i++];
            } else {
                minHeight = arr[j--];
            }
            max = Math.max(max, (j - i + 1) * minHeight);

        }
        return max;
    }
}
