package com.lele.leetcode;

import com.lele.base.ListNode;

import static com.lele.base.ListNode.printListByHead;

/**
 * @author: lele
 * @date: 2024/3/12 17:31
 * @description: 合并两个有序链表
 * 描述：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */

public class MergeTwoLists {

    public static void main(String[] args) {

        // 构造输入链表
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        l4.next = l5;
        l5.next = l6;
        l6.next = null;

        // 合并有序链表
        ListNode listNode = mergeTwoLists(l1, l4);

        // 根据头结点打印链表
        printListByHead(listNode);
    }

    /**
     * 合并两个有序链表
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的链表
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 定义一个虚拟的头结点（创建新的链表时需要）
        ListNode head = new ListNode(-1), p = head;
        ListNode p1 = list1, p2 = list2;

        while(p1 != null && p2 != null) {
            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }

            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }

        return head.next;
    }
}


