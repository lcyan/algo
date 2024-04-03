package cn.vvspace.algo.repeat;

import cn.vvspace.algo.base.ListNode;

/**
 * <a href="">返回链表的倒数第 k 个节点</a>
 */
public class Solution004 {

    public ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head, p2 = head;

        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        return p2;
    }
}
