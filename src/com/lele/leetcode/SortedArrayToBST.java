package com.lele.leetcode;

import com.lele.base.BinaryTree;
import com.lele.base.TreeNode;

/**
 * @author: lele
 * @date: 2024/3/18 17:40
 * @description: 将有序数组转换为二叉搜索树
 *
 * 描述：给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵平衡二叉搜索树。
 *
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案
 *
 * 思路：
 * 二叉搜索树的中序遍历是升序序列，题目给定的数组是按照升序排序的有序数组，因此可以确保数组是二叉搜索树的中序遍历序列。
 *
 * 直观地看，我们可以选择中间数字作为二叉搜索树的根节点，这样分给左右子树的数字个数相同或只相差 111，可以使得树保持平衡。
 * 如果数组长度是奇数，则根节点的选择是唯一的，如果数组长度是偶数，则可以选择中间位置左边的数字作为根节点或者选择中间位置右边的数字作为根节点，
 * 选择不同的数字作为根节点则创建的平衡二叉搜索树也是不同的。
 *
 */

public class SortedArrayToBST {

    public static void main(String[] args) {
        int[] array = {-10,-3,0,5,9};
        System.out.println("输出：" + BinaryTree.infixOrder(sortedArrayToBST(array)));
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    /**
     * 中序遍历，总是选择中间位置左边的数字作为根节点
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private static TreeNode helper(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, l, mid - 1);
        root.right = helper(nums, mid + 1, r);

        return root;
    }
}
