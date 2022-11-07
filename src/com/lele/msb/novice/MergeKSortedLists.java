package com.lele.msb.novice;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: lele
 * @date: 2022/11/4 08:09
 * @description: 合并多个有序链表
 */

public class MergeKSortedLists {

    public static class ListNode{
        public int val;
        public ListNode next;

        public static class ListNodeComparator implements Comparator<ListNode> {

            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val = o2.val;
            }
        }

        public static ListNode mergeKLists(ListNode[] lists) {
            if (lists == null) {
                return null;
            }

            PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    heap.add(lists[i]);
                }
            }
            if (heap.isEmpty()) {
                return null;
            }
            ListNode head = heap.poll();
            ListNode pre = head;
            if (pre.next != null) {
                heap.add(pre.next);
            }

            while(!heap.isEmpty()) {
                ListNode cur = heap.poll();
                pre.next = cur;
                pre = cur;
                if (cur.next != null) {
                    heap.add(cur.next);
                }
            }
            return head;
        }
    }
}
