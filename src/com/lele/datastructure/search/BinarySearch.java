package com.lele.datastructure.search;

/**
 * @author: lele
 * @date: 2021/5/25 17:54
 * @description:
 */

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        System.out.println(binarySearch.binarySearch(arr, 0, 9, 6));
    }

    public int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else {
            return mid;
        }
    }
}
