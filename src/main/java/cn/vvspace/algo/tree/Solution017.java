package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.ListNode;

/**
 * <a href="">倒序打印一条单链表上所有节点的值</a>
 */
public class Solution017 {

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        traverse(head);
    }

    private static void traverse(ListNode head) {
        if (head == null) {
            return;
        }

        traverse(head.next);
        System.out.print(head.val + " ");
    }
}
