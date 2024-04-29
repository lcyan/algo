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

    public static void main(String[] args) {
    }

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

    // 递归解法
    // 定义：输入一条单链表头结点，返回去重之后的单链表头结点
    public ListNode deleteDuplicatesV1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val != head.next.val) {
            // 如果头结点和身后节点的值不同，则对之后的链表去重即可
            head.next = deleteDuplicates(head.next);
            return head;
        }

        while (head.next != null && head.val == head.next.val) {
            head = head.next;
        }

        return deleteDuplicates(head.next);
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

    // 92. 反转链表 II
    // 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
    public ListNode reverseBetween(ListNode head, int left, int right) {
        return null;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverse(head);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
