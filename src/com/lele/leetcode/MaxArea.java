package com.lele.leetcode;

/**
 * @author: lele
 * @date: 2021/5/22 08:24
 * @description: 盛最多水的容器
 * 描述：给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * 思路：
 * 1.横向长度：横坐标的差
 * 2.纵向高度：短板高度
 * 最大水量 = 横向长度 * 纵向长度
 */

public class MaxArea {
    public static void main(String[] args) {

        int[] arr = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea1(arr));
    }


    /**
     * 双指针
     * @param arr
     * @return
     */
    private static int maxArea1(int[] arr) {
        int res = 0, left = 0, right = arr.length - 1;

        while(left < right) {
            res = arr[left] < arr[right]
                    ? Math.max(res, (right - left) * arr[left++])
                    : Math.max(res, (right - left) * arr[right--]);
        }

        return res;
    }

    private static int maxArea (int[] arr) {
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
