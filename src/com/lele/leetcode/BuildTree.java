package com.lele.leetcode;

import com.lele.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lele
 * @date: 2024/3/18 18:08
 * @description: 从前序遍历与中序遍历序列构造二叉树
 *
 * 描述：给定两个整数数组 preorder 和 inorder ，
 * 其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 *
 * 思路：
 * 先序遍历的顺序是根节点，左子树，右子树。中序遍历的顺序是左子树，根节点，右子树。
 * 所以我们只需要根据先序遍历得到根节点，然后在中序遍历中找到根节点的位置，它的左边就是左子树的节点，右边就是右子树的节点。
 * 生成左子树和右子树就可以递归的进行了。
 */

public class BuildTree {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};


    }

    /**
     * 递归实现
     * @param preorder
     * @param inorder
     * @return
     */
    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    private static TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end,
                                            int[] inorder, int i_start, int i_end, Map<Integer, Integer> map) {
        if (p_start == p_end) {
            return null;
        }

        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        int i_root_index = map.get(root_val);
        int leftNum = i_root_index - i_start;

        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index, map);
        root.right = buildTreeHelper(preorder, p_start +leftNum + 1, p_end, inorder, i_root_index + 1, i_end, map);

        return root;
    }
}
