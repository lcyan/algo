package cn.vvspace.algo.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {this.val = val;}

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void print(ListNode head) {
        List<Integer> result = new ArrayList<>();
        ListNode p = head;

        while (p != null) {
            result.add(p.val);
            p = p.next;
        }

        System.out.println(Arrays.toString(result.toArray(new Integer[0])));
    }

    public static ListNode of(Integer... elements) {
        ListNode dummy = new ListNode(-1, null);
        ListNode p = dummy;

        for (Integer element : elements) {
            p.next = new ListNode(element);
            p = p.next;
        }

        return dummy.next;
    }
}
