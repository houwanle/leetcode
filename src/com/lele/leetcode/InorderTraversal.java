package com.lele.leetcode;

import com.lele.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: lele
 * @date: 2024/3/14 16:58
 * @description: 二叉树的中序遍历
 * 描述：给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 */

public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.print("二叉树的中序遍历：");

        for (Integer i : inorderTraversal(root)) {
            System.out.print(i + " ");
        }
    }

    /**
     * 二叉树的中序遍历(递归实现)
     * @return
     */
    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root != null) {
            // 利用函数定义，左子树的中序遍历结果
            res.addAll(inorderTraversal(root.left));
            // 中序遍历结果，根在中间
            res.add(root.val);
            // 利用函数定义，接着右子树的中序遍历结果
            res.addAll(inorderTraversal(root.right));
        }

        return res;
    }

    /**
     * 二叉树的中序遍历(非递归实现)
     * @param root
     * @return
     */
    private static List<Integer> inorderTraversal1(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || stack.size() > 0) {
            //不断往左子树方向走，每走一次就将当前节点保存到栈中
            //这是模拟递归的调用
            if (root != null) {
                stack.push(root);
                root = root.left;

                //当前节点为空，说明左边走到头了，从栈中弹出节点并保存
                //然后转向右边节点，继续上面整个过程
            } else {
                TreeNode temp = stack.pop();
                res.add(temp.val);
                root = temp.right;
            }
        }

        return res;
    }
}
