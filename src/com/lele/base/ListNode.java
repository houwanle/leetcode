package com.lele.base;

/**
 * @author: lele
 * @date: 2024/3/12 17:36
 * @description: ListNode 链表结点类
 */

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 生成链表
     * @param data 输入的数组
     * @return 链表的头结点
     */
    public static ListNode generateLinkedList(int[] data) {
        if (data == null || data.length == 0) {
            return null;
        }

        ListNode head = new ListNode(data[0]);
        ListNode current = head;

        for (int i = 1; i < data.length; i++) {
            current.next = new ListNode(data[i]);
            current = current.next;
        }
        return head;
    }

    /**
     * 根据头结点打印链表
     * @param head
     */
    public static void printListByHead(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode temp = head;
        while(true) {
            if (temp == null) {
                break;
            }

            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
