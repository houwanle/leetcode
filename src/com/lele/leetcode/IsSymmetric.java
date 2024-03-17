package com.lele.leetcode;

import com.lele.base.BinaryTree;
import com.lele.base.TreeNode;

/**
 * @author: lele
 * @date: 2024/3/17 14:35
 * @description: 对称二叉树
 * 描述：给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 思路：
 * 我们可以实现这样一个递归函数，通过「同步移动」两个指针的方法来遍历这棵树，
 * p 指针和 q 指针一开始都指向这棵树的根，随后 p右移时，q 左移，p 左移时，q 右移。
 * 每次检查当前 p 和 q 节点的值是否相等，如果相等再判断左右子树是否对称。
 */

public class IsSymmetric {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("输出:" + isSymmetric(root));
    }

    private static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    /**
     * 校验对称二叉树
     * @param p 左指针
     * @param q 右指针
     * @return
     */
    private static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
