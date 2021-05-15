package com.lele.datastructure.tree;

import java.util.Stack;

/**
 * @author: lele
 * @date: 2021/5/15 19:26
 * @description: 二叉树的前序、中序、后序遍历 的递归实现和非递归实现
 */

public class BinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        //===========非递归实现============

//        System.out.println("前序遍历（根左右）");
//        binaryTree.preOrder(root);

//        System.out.println("中序遍历（左根右）");
//        binaryTree.infixOrder(root);

//        System.out.println("后序遍历（左右根）");
//        binaryTree.postOrder(root);


        //============递归实现==============
//        System.out.println("前序遍历");
//        binaryTree.preOrder1(root);

//        System.out.println("中序遍历");
//        binaryTree.infixOrder1(root);

        System.out.println("后序遍历");
        binaryTree.postOrder1(root);
    }

    /**
     * 二叉树的前序遍历--递归实现
     * @param root
     */
    public void preOrder1(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + ",");
            preOrder1(root.left);
            preOrder1(root.right);
        }
    }

    /**
     * 二叉树的中序遍历--递归实现
     * @param root
     */
    public void infixOrder1(TreeNode root) {
        if (root != null) {
            infixOrder1(root.left);
            System.out.print(root.value + ",");
            infixOrder1(root.right);
        }
    }

    /**
     * 二叉树的后续遍历--递归实现
     * @param root
     */
    public void postOrder1(TreeNode root) {
        if (root != null) {
            postOrder1(root.left);
            postOrder1(root.right);
            System.out.print(root.value + ",");
        }
    }


    /***********************非递归实现**********************/
    /**
     * 二叉树的前序遍历(根左右）--非递归实现
     * @param root
     */
    public void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = root;
        stack.push(t);

        while(!stack.isEmpty()) {
            t = stack.pop();
            System.out.print(t.value + ",");
            if (t.right != null) {
                stack.push(t.right);
            }
            if (t.left != null) {
                stack.push(t.left);
            }
        }

        System.out.println("");
    }

    /**
     * 二叉树的中序遍历（左根右）--非递归实现
     * @param root
     */
    public void infixOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = root;
        while(t != null || !stack.isEmpty()) {
            if (t != null) {
                stack.push(t);
                t = t.left;
            } else {
                t = stack.pop();
                System.out.print(t.value + ",");
                t = t.right;
            }
        }
    }

    /**
     * 二叉树的后序遍历（左右根）--非递归实现
     * @param root
     */
    public void postOrder(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode t = root;

        stack1.push(t);
        while(!stack1.isEmpty()) {
            t = stack1.pop();
            stack2.push(t);

            if (t.left != null) {
                stack1.push(t.left);
            }

            if (t.right != null) {
                stack1.push(t.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value + ",");
        }

    }
}


class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }
}
