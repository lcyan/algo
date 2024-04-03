package cn.vvspace.algo.repeat;

import cn.vvspace.algo.base.ListNode;

/**
 * <a href="https://leetcode.cn/problems/partition-list/">86. 分隔链表</a>
 */
public class Solution002 {

    public ListNode partition(ListNode head, int x) {
        ListNode dummyL = new ListNode(-1);
        ListNode dummyR = new ListNode(-1);
        ListNode left = dummyL;
        ListNode right = dummyR;

        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                left.next = p;
                left = left.next;
            } else {
                right.next = p;
                right = right.next;
            }

            // 不能直接让 p 指针前进，
            // p = p.next
            // 断开原链表中的每个节点的 next 指针
            ListNode tmp = p.next;
            p.next = null;
            p = tmp;
        }
        left.next = dummyR.next;
        return dummyL.next;
    }
}
