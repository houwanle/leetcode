package com.lele.utils;

import java.util.Arrays;

/**
 * @author: lele
 * @date: 2024/1/9 15:54
 * @description: 对数器：用于验证编写的Java程序
 */

public class LogarithmizerUtil {

    /**
     * 打印数组
     * @param arr  需要打印的数组
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 判断两个数组是否相等
     * @param arr1 数组1
     * @param arr2 数组2
     * @return true:相等；  false:不相等
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * 拷贝数组
     * @param arr 被拷贝的数组
     * @return  拷贝后的数组
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 生成随机数组
     * @param maxSize  数组最大长度
     * @param maxValue  数组中的最大值
     * @return  生成的数组
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
//        Math.random()  [0, 1)
//        Math.random() * N  [0, N)
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++){
//            [-?, +?]
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     * Arrays.sort() 采用快排排序
     * @param arr  数组
     */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 交换 arr[i] 和 arr[j] 的值
     * @param arr 数组
     * @param i  i位置
     * @param j  j位置
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
