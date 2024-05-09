package cn.vvspace.algo.repeat.linkedlistr;

import cn.vvspace.algo.base.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/">82. 删除排序链表中的重复元素 II</a>
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-an-unsorted-linked-list/">1836. 从未排序的链表中移除重复元素 </a>
 * <a href="https://leetcode.com/problems/reverse-linked-list-ii/">92. 反转链表 II</a>
 */
public class Solution002 {


    // 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
    // head = [1,2,3,3,4,4,5] => [1, 2, 5]
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy, q = head;

        while (q != null) {

            if (q.next != null && q.val == q.next.val) {

                while (q.next != null && q.val == q.next.val) {
                    q = q.next;
                }

                q = q.next;

                if (q == null) {
                    p.next = null;
                }
            } else {
                p.next = q;
                q = q.next;
                p = p.next;
            }
        }

        return dummy.next;
    }


    ListNode successor = null;

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        System.out.println(new Solution002().reverse(head));
    }

    public ListNode deleteDuplicatesV4(ListNode head) {
        ListNode dummy = new ListNode(-1), q = head;
        ListNode p = dummy;

        while (q != null) {
            if (q.next != null && q.val == q.next.val) {
                while (q.next != null && q.val == q.next.val) {
                    q = q.next;
                }
                q = q.next;

                if (q == null) {
                    p.next = null;
                }
            } else {
                p.next = q;
                q = q.next;
                p = p.next;
            }
        }

        return dummy.next;
    }


    // 1836. 从未排序的链表中移除重复元素

    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> count = new HashMap<>();

        // 先遍历一遍链表，记录每个值出现的次数
        ListNode p = head;
        while (p != null) {
            count.put(p.val, count.getOrDefault(p.val, 0) + 1);
            p = p.next;
        }

        // 虚拟头结点（哨兵节点），存放结果链表
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 再遍历一遍节点，把重复出现的节点剔除
        p = dummy;

        while (p != null) {

            // unique 指针负责寻找不重复的节点
            ListNode unique = p.next;
            while (unique != null && count.get(unique.val) > 1) {
                // 跳过重复节点，直到找到不重复的节点
                unique = unique.next;
            }

            // 接入不重复的节点或尾部空指针
            p.next = unique;

            // p 前进，继续寻找不重复节点
            p = p.next;
        }

        return dummy.next;

    }


    public ListNode deleteDuplicatesUnsortedV6(ListNode head) {
        Map<Integer, Integer> cnt = new HashMap<>();
        ListNode p = head;
        while (p != null) {
            cnt.put(p.val, cnt.getOrDefault(p.val, 0) + 1);
            p = p.next;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        p = dummy;

        while (p != null) {
            ListNode unique = p;
            while (unique != null && cnt.get(unique.val) > 1) {
                unique = unique.next;
            }
            p.next = unique;
            p = p.next;
        }

        return dummy.next;
    }


    // 递归解法
    // 定义：输入一条单链表头结点，返回去重之后的单链表头结点
    public ListNode deleteDuplicatesV1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val != head.next.val) {
            // 如果头结点和身后节点的值不同，则对之后的链表去重即可
            head.next = deleteDuplicatesV1(head.next);
            return head;
        }

        while (head.next != null && head.val == head.next.val) {
            head = head.next;
        }

        return deleteDuplicatesV1(head.next);
    }

    // 函数定义：输入一个节点 head，将「以 head 为起点」的链表反转，并返回反转之后的头结点。
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode last = reverse(head.next);
        head.next.next = last;
        head.next = null;
        return last;
    }


    // 反转以 head 为起点的 n 个节点，返回新的头结点
    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    // 反转链表的一部分

    private ListNode reverseBetween(ListNode head, int m, int n) {

        if (m == 1) {
            return reverseN(head, n);
        }

        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

}


