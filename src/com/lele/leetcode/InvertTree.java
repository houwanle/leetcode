package com.lele.leetcode;

import com.lele.base.BinaryTree;
import com.lele.base.TreeNode;

/**
 * @author: lele
 * @date: 2024/3/14 21:10
 * @description: 翻转二叉树
 * 描述：给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 */

public class InvertTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println("翻转之前的二叉树：" + BinaryTree.levelOrder(root));

        System.out.println("翻转之后的二叉树：" + BinaryTree.levelOrder(invertTree(root)));
    }

    /**
     * 翻转二叉树-递归实现
     * @param root 根结点
     * @return
     */
    private static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }
}
