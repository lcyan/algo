package cn.vvspace.algo.repeat.linkedlist;

import cn.vvspace.algo.base.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/merge-k-sorted-lists/description/">23. 合并 K 个升序链表</a>
 */
public class Solution003 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));
        for (ListNode head : lists) {
            if (null != head) {
                q.offer(head);
            }
        }

        while (!q.isEmpty()) {
            ListNode cur = q.poll();
            p.next = cur;
            assert cur != null;
            if (cur.next != null) {
                q.offer(cur.next);
                cur.next = null;
            }
            p = p.next;
        }
        return dummy.next;
    }
}
