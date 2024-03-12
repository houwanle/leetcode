package com.lele.leetcode;

/**
 * @author: lele
 * @date: 2023/5/22 18:38
 * @description: 最小路径和
 *
 * 题目描述：给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：一个机器人每次只能向下或者向右移动一步。
 *
 * 走到当前单元格 (i,j)的最小路径和 = “从左方单元格 (i−1,j) 与 从上方单元格 (i,j-1)走来的 两个最小路径和中较小的 ” + 当前单元格值grid[i][j] 。
 * 具体分为以下 4 种情况：
 * 1. 当左边和上边都是矩阵边界时： 即当i=0,j=0时，其实就是起点， dp[i][j] = grid[i][j]；
 * 2. 当左边和上边都不是矩阵边界时： 即当i≠0，j≠0时，dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j] ；
 * 3. 当只有左边是矩阵边界时： 只能从上面来，即当i=0,j≠0时， dp[i][j] = dp[i][j - 1] + grid[i][j ；
 * 4. 当只有上边是矩阵边界时： 只能从左面来，即当i≠0,j=0时， dp[i][j] = dp[i - 1][j] + grid[i][j]；
 */

public class MinPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};

        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                if (i != 0 && j != 0) {
                    grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
                }

                if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j-1] + grid[i][j];
                }

                if (i != 0 && j == 0) {
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                }
            }
        }

        return grid[grid.length-1][grid[0].length - 1];
    }
}
