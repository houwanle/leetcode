package com.lele.msb.novice;

/**
 * @author: lele
 * @date: 2022/7/28 上午7:18
 * @description: 插入排序
 */

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {8,7,3,2,6,5,4,3,1,2,1};

        printArray(arr);
        insertSort2(arr);
        printArray(arr);
    }

    public static void insertSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int end = 1; end < arr.length; end++) {
            int newNumIndex = end;
            while (newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]) {
                swap(arr, newNumIndex - 1, newNumIndex);
                newNumIndex--;
            }
        }
    }

    public static void insertSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int end = 1; end < arr.length; end++) {
            for (int pre = end - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
                swap(arr, pre, pre + 1);
            }
        }
    }


    public static void swap(int[] arr, int i, int j) {
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
