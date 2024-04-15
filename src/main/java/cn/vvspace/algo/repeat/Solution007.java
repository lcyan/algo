package cn.vvspace.algo.repeat;

import cn.vvspace.algo.base.ListNode;

/**
 * <a href="">链表是否包含环</a>
 */
public class Solution007 {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
