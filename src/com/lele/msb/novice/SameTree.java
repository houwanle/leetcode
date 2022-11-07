package com.lele.msb.novice;

/**
 * @author: lele
 * @date: 2022/11/8 07:39
 * @description: 二叉树是否相等（结构是否完全相同）
 * leetcode-100 相同的树
 */

public class SameTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null ^ q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
