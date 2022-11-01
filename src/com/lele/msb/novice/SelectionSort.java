package com.lele.msb.novice;

/**
 * @author: lele
 * @date: 2022/7/27 上午7:13
 * @description: 选择排序
 */

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {7,4,5,1,3,8,9,0,2};

        printArray(arr);
        selectSort(arr);
        printArray(arr);

    }

    public static void selectSort(int[] arr) {
        int N = arr.length;

        if (arr == null || N < 2) {
            return;
        }

        for (int i = 0; i < N; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < N; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }

            swap(arr, i, minValueIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
