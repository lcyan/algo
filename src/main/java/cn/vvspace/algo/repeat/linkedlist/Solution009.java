package cn.vvspace.algo.repeat.linkedlist;

import cn.vvspace.algo.base.ListNode;

/**
 * <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/description/">160. 相交链表</a>
 */
public class Solution009 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;

        while (p1 != p2) {
            if (p1 != null) {
                p1 = p1.next;
            } else {
                p1 = headB;
            }

            if (p2 != null) {
                p2 = p2.next;
            } else {
                p2 = headA;
            }
        }

        return p1;
    }
}
