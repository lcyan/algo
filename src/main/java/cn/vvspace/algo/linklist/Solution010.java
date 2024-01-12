package cn.vvspace.algo.linklist;

import cn.vvspace.algo.base.ListNode;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/">83. 删除排序链表中的重复元素</a>
 * <p>
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * <p>
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 */
public class Solution010 {

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 1, 2, 3, 3);
        ListNode.print(deleteDuplicates(head));
    }

    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode slow = head, fast = head;

        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
