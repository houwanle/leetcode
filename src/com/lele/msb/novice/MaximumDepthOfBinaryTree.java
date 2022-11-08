package com.lele.msb.novice;

/**
 * @author: lele
 * @date: 2022/11/8 08:07
 * @description: 二叉树的最大深度
 * leetcode 104
 */

public class MaximumDepthOfBinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
