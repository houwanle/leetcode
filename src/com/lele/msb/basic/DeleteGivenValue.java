package com.lele.msb.basic;

/**
 * @author: lele
 * @date: 2023/4/10 07:37
 * @description: 删除单链表中给定的值
 */

public class DeleteGivenValue {

    public static class Node {

        public int value;
        public Node next;

        public static Node removeValue(Node head, int num) {
            while (head != null) {
                if (head.value != num) {
                    break;
                }
                head = head.next;
            }
            // head来到 第一个不需要删的位置
            Node pre = head;
            Node cur = head;
            while (cur != null) {
                if (cur.value == num) {
                    pre.next = cur.next;
                } else {
                    pre = cur;
                }
                cur = cur.next;
            }
            return head;
        }
    }
}
