package cn.vvspace.algo.repeat.linkedlistr;

import cn.vvspace.algo.base.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/description/">21. 合并两个有序链表</a>
 * <a href="https://leetcode.cn/problems/partition-list/description/">86. 分隔链表</a>
 * <a href="https://leetcode.cn/problems/merge-k-sorted-lists/description/">23. 合并 K 个升序链表</a>
 * <a href="https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/description/">02. 返回倒数第 k 个节点</a>
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">19. 删除链表的倒数第 N 个结点</a>
 * <a href="https://leetcode.cn/problems/middle-of-the-linked-list/description/">876. 链表的中间结点</a>
 */
public class Solution001 {

    public static void main(String[] args) {
    }

    // 21. 合并两个有序链表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode p1 = list1, p2 = list2, dummy = new ListNode(-1);
        ListNode p = dummy;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }

            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }

        return dummy.next;

    }

    //86. 分隔链表
    // 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
    //你应当 保留 两个分区中每个节点的初始相对位置。
    public ListNode partition(ListNode head, int x) {
        ListNode dummyL = new ListNode(-1);
        ListNode dummyR = new ListNode(-1);

        ListNode pL = dummyL, pR = dummyR, p = head;

        while (p != null) {
            if (p.val < x) {
                pL.next = p;
                pL = pL.next;
            } else {
                pR.next = p;
                pR = pR.next;
            }

            ListNode tmp = p.next;
            p.next = null;
            p = tmp;
        }

        pL.next = dummyR.next;
        return dummyL.next;
    }

    // 23. 合并 K 个升序链表
    // 给你一个链表数组，每个链表都已经按升序排列。
    // 请你将所有链表合并到一个升序链表中，返回合并后的链表。
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1), p = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));

        for (ListNode head : lists) {
            if (head != null) {
                queue.offer(head);
            }
        }

        while (!queue.isEmpty()) {
            ListNode cur = queue.poll();
            p.next = cur;
            if (cur.next != null) {
                queue.offer(cur.next);
            }
            p = p.next;
        }
        return dummy.next;
    }

    // 单链表的倒数第 k 个节点
    public ListNode kthToLast(ListNode head, int k) {
        ListNode p1 = head;

        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        ListNode p2 = head;

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    // 19. 删除链表的倒数第 N 个结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 找到倒数第N+1个节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy;
        for (int i = 0; i < n + 1; i++) {
            p1 = p1.next;
        }

        ListNode p2 = dummy;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        ListNode toDelete = p2.next;
        p2.next = toDelete.next;
        toDelete.next = null;
        return dummy.next;
    }

    // 876. 链表的中间结点
    // 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
    // 如果有两个中间结点，则返回第二个中间结点。
    // 1, 2, 3, 4, 5, 6
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // 判定链表是否包含环
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    //如果链表中含有环，如何计算这个环的起点？
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    // 给你输入两个链表的头结点 headA 和 headB，这两个链表可能存在相交。
    // 如果相交，你的算法应该返回相交的那个节点；如果没相交，则返回 null
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;

        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }

        return p1;
    }

}
