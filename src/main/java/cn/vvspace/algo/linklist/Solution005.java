package cn.vvspace.algo.linklist;


import cn.vvspace.algo.base.ListNode;

/**
 * <a href="https://leetcode.cn/problems/middle-of-the-linked-list/description/">876. 链表的中间结点</a>
 * <p>
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[3,4,5]
 * <p>
 * 输入：head = [1,2,3,4,5,6]
 * 输出：[4,5,6]
 */
public class Solution005 {

    public static void main(String[] args) {
        ListNode list1 = ListNode.of(1, 2, 3, 4, 5);
        ListNode list2 = ListNode.of(1, 2, 3, 4, 5, 6);

        ListNode.print(middleNode(list1));
        ListNode.print(middleNode(list2));
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
