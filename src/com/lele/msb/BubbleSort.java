package com.lele.msb;

/**
 * @author: lele
 * @date: 2022/7/27 上午7:33
 * @description: 冒泡排序
 */

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {9,4,3,6,2,1,5,0,8,7,6};

        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }

    private static void bubbleSort(int[] arr) {
        int N = arr.length;

        if (arr == null || arr.length < 2) {
            return;
        }

        for (int end = N - 1; end >= 0; end--) {
            for (int second = 1; second <= end; second++) {
                if (arr[second-1] > arr[second]) {
                    swap(arr, second-1, second);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}
