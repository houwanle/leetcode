package com.lele.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: lele
 * @date: 2024/3/14 21:23
 * @description: 二叉树相关方法
 */

public class BinaryTree {

    /**
     * 二叉树前序遍历-递归实现
     * @param root
     * @return
     */
    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root != null) {
            res.add(root.val);
            res.addAll(preOrder(root.left));
            res.addAll(preOrder(root.right));
        }

        return res;
    }

    /**
     * 二叉树中序遍历-递归实现
     * @param root
     * @return
     */
    public static List<Integer> infixOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root != null) {
            res.addAll(infixOrder(root.left));
            res.add(root.val);
            res.addAll(infixOrder(root.right));
        }

        return res;
    }

    /**
     * 二叉树后序遍历-递归实现
     * @param root
     * @return
     */
    public static List<Integer> postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root != null) {
            res.addAll(postOrder(root.left));
            res.addAll(postOrder(root.right));
            res.add(root.val);
        }

        return res;
    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
