package cn.vvspace.algo.linklist;


import cn.vvspace.algo.base.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/merge-k-sorted-lists/description/">23. 合并 K 个升序链表</a>
 */
public class Solution002 {

    public static void main(String[] args) {
        ListNode listNode1 = ListNode.of(1, 4, 5);
        ListNode listNode2 = ListNode.of(1, 3, 4);
        ListNode listNode3 = ListNode.of(2, 6);
        ListNode[] lists = new ListNode[]{listNode1, listNode2, listNode3};
        ListNode.print(mergeKLists(lists));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(len, Comparator.comparingInt(a -> a.val));
        // 构建优先队列
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!pq.isEmpty()) {
            // 获取最小元素
            ListNode node = pq.poll();
            p.next = node;

            if (node.next != null) {
                pq.add(node.next);
            }

            p = p.next;
        }

        return dummy.next;
    }
}
