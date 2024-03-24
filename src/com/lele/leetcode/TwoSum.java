package com.lele.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: lele
 * @date: 2021/3/6 20:14
 * @description: 两数之和
 * 描述：给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15,10,9,0,1,5,4};
        int target = 12;

        TwoSum test = new TwoSum();

        int[] index = test.twoSum(nums, target);

        System.out.println(Arrays.toString(index));
    }

    /**
     * 两数之和 静态哈希表
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                index[0] = map.get(nums[i]);
                index[1] = i;
            }

            // 将 差 当作 key，索引 当作value
            map.put(target-nums[i], i);
        }

        return index;
    }
}
