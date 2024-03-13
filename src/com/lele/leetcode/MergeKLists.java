package com.lele.leetcode;

import com.lele.base.ListNode;

import java.util.PriorityQueue;

/**
 * @author: lele
 * @date: 2024/3/13 18:49
 * @description: 合并K个升序链表
 * 描述：给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 */

public class MergeKLists {

    public static void main(String[] args) {

    }

    private static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode head = new ListNode(-1);
        ListNode p = head;

        // 优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, (a, b) -> (a.val - b.val));

        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }

            p = p.next;
        }
        return head.next;
    }
}
