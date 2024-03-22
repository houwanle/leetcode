package com.lele.nowcoder;

/**
 * @author: lele
 * @date: 2024/3/22 17:28
 * @description: 跳台阶
 * 描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 数据范围：1<= n <= 40
 * 要求：时间复杂度：O(n)，空间复杂度O(1)
 *
 * 输入：
 * 7
 * 返回值：
 * 21
 */

public class JumpFloor {

    public static void main(String[] args) {
        System.out.println(jumpFloor1(7));
    }

    /**
     * 递归实现
     * @param number 总台阶数
     * @return 跳法
     */
    private static int jumpFloor(int number) {
        if (number == 1) { //只有一个台阶的时候就有一种跳法
            return 1;
        }
        if (number == 2) {//只有2个台阶的时候就有2种跳法1）每次跳1格2）直接跳2格
            return 2;
        }

        //第n个台阶是不是可以从第n-1个台阶跳过来，或者第n-2格台阶跳过来，总和就是第n个台阶的总和
        return jumpFloor(number - 1) + jumpFloor(number - 2);
    }

    /**
     * 动态规划
     * @param number 总台阶数
     * @return 跳法
     */
    private static int jumpFloor1(int number) {
        int[] dp = new int[number + 10];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= number; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[number];
    }
}
