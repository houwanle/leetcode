package com.lele.msb.novice;

/**
 * @author: lele
 * @date: 2022/11/21 07:51
 * @description: 路径总和
 * leetcode 112
 * 测试链接：https://leetcode.com/problems/path-sum
 */

public class PathSum {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSum = false;

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        isSum = false;
        process(root, 0, sum);
        return isSum;
    }

    private static void process(TreeNode x, int preSum, int sum) {
        if (x.left == null && x.right == null) {
            if (x.val + preSum == sum) {
                isSum = true;
            }
            return;
        }

        // x 是非叶子节点
        preSum += x.val;
        if (x.left != null) {
            process(x.left, preSum, sum);
        }
        if (x.right != null) {
            process(x.right, preSum, sum);
        }
    }

    public static boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return process2(root, sum);
    }

    private static boolean process2(TreeNode root, int rest) {
        if (root.left == null && root.right == null) {
            return root.val == rest;
        }

        boolean ans = root.left != null ? process2(root.left, rest - root.val) : false;
        ans |= root.right != null ? process2(root.right, rest - root.val) : false;
        return ans;
    }
}
