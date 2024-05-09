package cn.vvspace.algo.repeat.linkedlistr;

import cn.vvspace.algo.base.ListNode;

/**
 * K 个一组反转链表
 */
public class Solution003 {

    // 反转以 a 为头结点的链表
    public ListNode reverse(ListNode a) {
        ListNode prev, cur, next;
        prev = null;
        cur = a;
        next = a;

        while (cur != null) {
            next = cur.next;
            // 逐个结点反转
            cur.next = prev;
            // 更新指针位置
            prev = cur;
            cur = next;
        }
        // 返回反转后的头结点
        return prev;
    }

    /** 反转区间 [a, b) 的元素，注意是左闭右开 */
    ListNode reverse(ListNode a, ListNode b) {
        ListNode prev, cur, next;
        prev = null;
        cur = a;
        next = a;
        while (cur != b) {
            next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }

        return prev;
    }

    ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);

        return newHead;
    }
}
