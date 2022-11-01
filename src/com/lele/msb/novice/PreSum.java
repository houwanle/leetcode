package com.lele.msb.novice;

/**
 * @author: lele
 * @date: 2022/7/29 上午7:48
 * @description: 前缀和
 */

public class PreSum {

    public static void main(String[] args) {
        int[] arr = {2,3,4,-1,5,6,9,0};

        System.out.println(rangeSum(arr, 0, 2));
    }

    private static int rangeSum(int[] arr, int L, int R) {
        int N = arr.length;

        int[] preSum;
        preSum = new int[N];
        preSum[0] = arr[0];
        for (int i = 1; i < N; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }

        return L == 0 ? preSum[R] : preSum[R] - preSum[L - 1];
    }
}
