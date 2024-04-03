package cn.vvspace.algo.repeat;

import cn.vvspace.algo.base.ListNode;

/**
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/">19. 删除链表的倒数第 N 个结点</a>
 */
public class Solution005 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头节点，可能会存在空指针的问题
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preNode = findFromEnd(dummy, n + 1);

        ListNode deleteNode = preNode.next;
        preNode.next = deleteNode.next;
        deleteNode.next = null;
        return dummy.next;
    }

    private ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head, p2 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
