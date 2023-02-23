package com.lele.msb.novice;

import java.util.Arrays;

/**
 * @author: lele
 * @date: 2023/2/22 08:18
 * @description: 有序数组中找到<=num最右的位置
 */

public class BSNearRight {

    public static void main(String[] args) {
        int testTimes = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;

        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int)((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != mostRightNoMoreNumIndex(arr, value)) {
                System.out.println(value);
                System.out.println(test(arr, value));
                System.out.println(mostRightNoMoreNumIndex(arr, value));
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "nice" : "fuck");
    }

    public static int mostRightNoMoreNumIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while(L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] <= num) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return ans;
    }

    public static int test(int[] arr, int value) {
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if (arr[i] <= value) {
                return i;
            }
        }
        return -1;
    }

    private static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random() - (int)(maxValue * Math.random()));
        }
        return arr;
    }
}
