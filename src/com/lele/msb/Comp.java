package com.lele.msb;

/**
 * @author: lele
 * @date: 2022/8/3 上午7:55
 * @description: 对数器
 */

public class Comp {

    public static void main(String[] args) {
        int maxLen = 50;
        int maxValue = 1000;
        int testTimes = 10000;

        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = lenRandomValueRandom(maxLen, maxValue);
            int[] tmp = copyArray(arr1);
            SelectionSort.selectSort(arr1);
            if (!isSorted(arr1)) {
                for (int j = 0; j < tmp.length; j++){
                    System.out.print(tmp[j]);
                }
                System.out.println("选择排序错了！");
            }
        }
    }

    /**
     * arr1与arr2 等长；
     * 判断两个数组是否相等
     * @param arr
     * @return
     */
    public static boolean isSorted(int[] arr) {
        if (arr.length < 2) {
            return true;
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max > arr[i]) {
                return false;
            }
            max = Math.max(max, arr[i]);
        }
        return true;
    }

    /**
     * 拷贝数组的方法
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    /**
     * 返回一个数组arr, arr长度[0,maxLen-1],arr中每个值[0,maxValue-1]
     * @param maxLen
     * @param maxValue
     * @return
     */
    public static int[] lenRandomValueRandom(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = (int) (Math.random() * maxValue);
        }
        return ans;
    }
}
