package com.lele.base;

/**
 * @author: lele
 * @date: 2024/3/12 17:36
 * @description: ListNode 基本类
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
