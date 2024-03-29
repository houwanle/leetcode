package com.lele.msb.novice;

/**
 * @author: lele
 * @date: 2022/11/15 07:40
 * @description: 平衡二叉树(左树高度与右树高度的绝对值小于等于1）
 */

public class BalanceBinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode (int val) {
            this.val = val;
        }
    }

    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean i, int h) {
            isBalanced = i;
            height = h;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }

    public static Info process(TreeNode root) {
        if (root == null) {
            return new Info(true, 0);
        }

        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced
                && Math.abs(leftInfo.height - rightInfo.height) < 2;
        return new Info(isBalanced, height);
    }
}
