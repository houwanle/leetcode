package com.lele.leetcode;

/**
 * @author: lele
 * @date: 2021/5/15 15:54
 * @description: 数组中的第K个最大元素
 */

public class FindKthLargest {
    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();

        int[] nums = {3,2,3,1,2,4,5,5,6};

        System.out.println(findKthLargest.findKthLargest(nums,4));
    }

    /**
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        // 官方API
//        Arrays.sort(nums);

        // 快速排序
        quickSort(nums, 0,nums.length-1);
        return nums[nums.length - k];
    }

    /**
     * 快速排序
     * @param arr 需要排序的数组
     * @param L  指向数组第一个元素
     * @param R  指向数组最后一个元素
     */
    public void quickSort(int[] arr, int L, int R) {
        int i = L;
        int j = R;

        // 支点
        int pivot = arr[(L+R)/2];

        // 左右两端进行扫描，只要两端还没有交替，就一直扫描
        while (i <= j) {
            // 寻找直到比支点大的数
            while (pivot > arr[i]) {
                i++;
            }
            // 寻找直到比支点小的数
            while (pivot < arr[j]) {
                j--;
            }

            // 此时已经分别找出比支点小的数（右边）、比支点大的数（左边），他们进行交换
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // 上面的while保证第一趟排序后 支点的左边比支点小，支点的右边比支点大

        // 左边再做排序，直到左边剩下一个数（递归出口）
        if (L < j) {
            quickSort(arr, L, j);
        }

        // 右边再做排序，直到右边剩下一个数（递归出口）
        if (i < R) {
            quickSort(arr, i, R);
        }
    }

}
