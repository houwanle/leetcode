package com.lele.leetcode;

import com.lele.base.BinaryTree;
import com.lele.base.TreeNode;

/**
 * @author: lele
 * @date: 2024/3/17 13:56
 * @description: 二叉搜索树中第K小的元素
 * 描述：给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 *
 * 思路：
 * 二叉搜索树的中序遍历是从小到大排序的，所以我们使用中序遍历来遍历这个二叉树，同时用count来记录是第几小的，当与k相等的时候返回。
 *
 */

public class KthSmallest {

    public static int count = 0;
    public static int target = 0;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.left.left.left = new TreeNode(1);

        System.out.println("输入：" + BinaryTree.levelOrder(root));
        System.out.println("输出：" + kthSmallest(root, 4));

    }


    private static int kthSmallest(TreeNode root, int k) {
        midOrder(root, k);
        return target;
    }

    /**
     * 中序遍历，寻找第K小元素
     * @param root 根节点
     * @param k
     */
    private static void midOrder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        midOrder(root.left, k);
        if (++count == k) {
            target = root.val;
            return;
        }
        midOrder(root.right, k);
    }
}
