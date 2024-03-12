package com.lele.leetcode;

import com.lele.base.ListNode;


/**
 * @author: lele
 * @date: 2021/3/7 07:50
 * @description: 两数相加
 */

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        l4.next = l5;
        l5.next = l6;
        l6.next = null;

        ListNode head = addTwoNumbers(l1, l4);

        ListNode.printListByHead(head);
    }


    /**
     * 两数相加（两联表从左往右依次相加，根据头结点输出相加后的结果）
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode current = root;
        int temp = 0;
        while (l1 != null || l2 != null || temp != 0) {
            int l1Val;
            int l2Val;
            if (l1 != null) {
                l1Val = l1.val;
            } else {
                l1Val = 0;
            }

            if (l2 != null) {
                l2Val = l2.val;
            } else {
                l2Val = 0;
            }

            int sumVal = l1Val + l2Val + temp;
            temp = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            current.next = sumNode;
            current = sumNode;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return root.next;
    }
}

