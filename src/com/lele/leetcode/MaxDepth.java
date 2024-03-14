package com.lele.leetcode;

import com.lele.base.TreeNode;

/**
 * @author: lele
 * @date: 2024/3/14 18:13
 * @description: 二叉树的最大深度
 * 描述：给定一个二叉树 root ，返回其最大深度。二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 */

public class MaxDepth {

    public static int ans = 0;
    public static int deep = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.print("二叉树的最大深度：" + maxDepth1(root));
    }

    /**
     * 深度优先(DFS，后序遍历)-递归实现
     * @param root 根节点
     * @return 最大深度
     */
    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

    /**
     * DFS + 回溯
     * @param root 根节点
     * @return 最大深度
     */
    private static int maxDepth1(TreeNode root) {
        traverse(root);
        return ans;
    }

    private static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        //进入该节点,层数加1
        deep++;
        if (root.left == null && root.right == null) {
            // 到达叶子节点，更新最大深度
            ans = Math.max(ans, deep);
        }
        //遍历左子树
        traverse(root.left);
        //遍历右子树
        traverse(root.right);
        //返回上一层,层数减1
        deep--;
    }

}
