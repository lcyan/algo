package cn.vvspace.algo.repeat.linkedlistr;

import cn.vvspace.algo.base.ListNode;

/**
 * 如何判断回文链表
 */
public class Solution004 {

    // 在s中寻找以s[left],s[right]为中心的回文字符串

    ListNode left;



    public String palindrome(String s, int left, int right) {
        if (left >= 0 && right < s.length() && s.charAt(left) != s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2));
        System.out.println(new Solution004().isPalindromeV1(head));
    }

    /**
     * 1、使用快慢指针使slow指向中间结点
     * 2、反转以slow位head的后续链表
     * 3、比对左半边和右半边的列表
     *
     * @param head head
     * @return isPalindrome
     */

    public boolean isPalindromeV1(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 说明链表长度为奇数
        if (fast != null) {
            slow = slow.next;
        }

        ListNode left = head;
        ListNode right = reverse(slow);

        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    private ListNode reverseV1(ListNode slow) {
        ListNode prev = null, cur = slow, next;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }

        return prev;
    }

    private ListNode reverse(ListNode slow) {
        if (slow == null || slow.next == null) {
            return slow;
        }
        ListNode last = reverse(slow.next);
        slow.next.next = slow;
        slow.next = null;
        return last;
    }

    private boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = traverse(right.next);
        res = res && left.val == right.val;
        left = left.next;
        return res;
    }

}
