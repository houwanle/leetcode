package com.lele.msb.novice;

/**
 * @author: lele
 * @date: 2022/11/7 08:03
 * @description: 二叉树递归遍历
 */

public class TraversalBinaryTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node (int v) {
            value = v;
        }
    }

    public static void f(Node head) {
        if (head == null) {
            return;
        }

        f(head.left);
        f(head.right);
    }

    // 先打印所有节点

    /**
     * 前序遍历（根节点）
     * @param head
     */
    public static void pre(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    /**
     * 中序遍历
     * @param head
     */
    public static void in(Node head) {
        if (head == null) {
            return;
        }
        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }

    /**
     * 后序遍历
     * @param head
     */
    public static void pos(Node head) {
        if (head == null) {
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.println(head.value);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        pre(head);
        System.out.println("===========");
        in(head);
        System.out.println("===========");
        pos(head);
        System.out.println("===========");
    }
}
