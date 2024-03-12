package com.lele.leetcode;

import com.lele.base.ListNode;


/**
 * @author: lele
 * @date: 2024/3/12 18:45
 * @description: 分隔链表
 * 描述：给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 *
 * 思路：
 * 我们可以把原链表分成两个小链表，一个链表中的元素大小都小于 x，
 * 另一个链表中的元素都大于等于 x，最后再把这两条链表接到一起，就得到了题目想要的结果。
 */

public class Partition {

    public static void main(String[] args) {
        // 构造输入链表
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = null;

        ListNode listNode = partition(l1, 3);

        // 根据头结点打印链表
        ListNode.printListByHead(listNode);
    }

    /**
     * 分隔链表
     * @param head 输入链表的头结点
     * @param x 特定值
     * @return 结果链表
     */
    public static ListNode partition(ListNode head, int x) {
        // 存放小于 x 的链表的虚拟头结点
        ListNode head1 = new ListNode(-1);
        // 存放大于 x 的链表的虚拟头结点
        ListNode head2 = new ListNode(-1);
        // p1、p2负责生成结果链表
        ListNode p1 = head1, p2 = head2;
        // 负责遍历原链表
        ListNode p = head;

        // 这里是将一个链表分解成两个链表
        while(p != null) {
            if (p.val >= x) {
                p2.next = p;
                p2 = p2.next;
            } else {
                p1.next = p;
                p1 = p1.next;
            }
            // 不能直接让 p 指针前进，
            // p = p.next
            // 断开原链表中的每个节点的 next 指针，否则会出现环
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        // 连接两个链表
        p1.next = head2.next;

        return head1.next;
    }
}
