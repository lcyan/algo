package cn.vvspace.algo.linklist;


import cn.vvspace.algo.base.ListNode;

/**
 * <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/description/">160. 相交链表</a>
 * <p>
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 * <p>
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 */
public class Solution008 {

    public static void main(String[] args) {
        ListNode listA = ListNode.of(4, 1, 8, 4, 5);
        ListNode listB = ListNode.of(5, 6, 1, 8, 4, 5);
        ListNode listNode = getIntersectionNode(listA, listB);
        ListNode listNode2 = getIntersectionNodeV2(listA, listB);
        System.out.println(listNode);
        System.out.println(listNode2);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;

        for (ListNode p = headA; p != null; p = p.next) {
            lenA++;
        }

        for (ListNode p = headB; p != null; p = p.next) {
            lenB++;
        }

        ListNode pA = headA, pB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                pA = pA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                pB = pB.next;
            }
        }

        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
        }

        return pA;
    }

    // a -> b -> c -> d -> e
    // a -> b ->d -> e

    public static ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;

        while (p1 != p2) {
            if (p1 != null) {
                p1 = p1.next;
            } else {
                p1 = headB;
            }

            if (p2 != null) {
                p2 = p2.next;
            } else {
                p2 = headA;
            }
        }

        return p1;
    }
}



