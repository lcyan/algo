package cn.vvspace.algo.linklist;


import cn.vvspace.algo.base.ListNode;

/**
 * <a href="https://leetcode.cn/problems/partition-list/description/">86. 分隔链表</a>
 * <p>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 */
public class Solution003 {

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 4, 3, 2, 5, 2);
        ListNode.print(partition(head, 3));
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode dummyL = new ListNode(-1), dummyR = new ListNode(-1);
        ListNode pL = dummyL, pR = dummyR;
        ListNode p = head;

        while (p != null) {

            if (p.val < x) {
                pL.next = p;
                pL = pL.next;
            } else {
                pR.next = p;
                pR = pR.next;
            }

            // 断开列表
            ListNode tmp = p.next;
            p.next = null;
            p = tmp;
        }

        pL.next = dummyR.next;
        return dummyL.next;
    }
}
