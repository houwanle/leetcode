package com.lele.base;

/**
 * @author: lele
 * @date: 2024/3/14 16:54
 * @description: 二叉树结点类
 */

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){};

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode (int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
