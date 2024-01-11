package cn.vvspace.algo;


import cn.vvspace.algo.base.ListNode;

/**
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/">19. 删除链表的倒数第 N 个结点</a>
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head
 */
public class Solution001 {

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        ListNode.print(removeNthFromEnd(head, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);

        ListNode x = findFromEnd(dummy, k + 1);
        ListNode tmp = x.next;
        x.next = tmp.next;
        tmp.next = null;

        return dummy.next;
    }

    public static ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head, p2 = head;

        // p1节点先走k步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        // p1, p2同时走n-k步
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
