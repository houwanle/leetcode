package com.lele.leetcode;

import com.lele.base.TreeNode;

/**
 * @author: lele
 * @date: 2024/3/17 17:38
 * @description: 二叉树的直径
 * 描述：给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 *
 * 输入：root = [1,2,3,4,5]
 * 输出：3
 * 解释：3，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
 *
 * 思路：
 * 假设我们知道对于该节点的左儿子向下遍历经过最多的节点数 L（即以左儿子为根的子树的深度）
 * 和其右儿子向下遍历经过最多的节点数 R （即以右儿子为根的子树的深度），
 * 那么以该节点为起点的路径经过节点数的最大值即为 L+R+1。二叉树的直径就是L+R。
 */

public class DiameterOfBinaryTree {

    public static int ans = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("输出：" + diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        getMax(root);
        return ans - 1;
    }
    public static int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getMax(root.left);
        int right = getMax(root.right);
        int temp = left + right + 1;
        ans = Math.max(ans, temp);

        return Math.max(left, right) + 1;
    }
}
