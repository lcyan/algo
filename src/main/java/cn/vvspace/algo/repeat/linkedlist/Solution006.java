package cn.vvspace.algo.repeat.linkedlist;

import cn.vvspace.algo.base.ListNode;

/**
 * <a href="https://leetcode.cn/problems/middle-of-the-linked-list/">876. 链表的中间结点</a>
 */
public class Solution006 {

    public ListNode middleNode(ListNode head) {

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return fast;

    }
}
