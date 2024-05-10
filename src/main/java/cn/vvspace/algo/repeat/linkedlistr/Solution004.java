package cn.vvspace.algo.repeat.linkedlistr;

import cn.vvspace.algo.base.ListNode;

/**
 * 如何判断回文链表
 */
public class Solution004 {

    // 在s中寻找以s[left],s[right]为中心的回文字符串

    ListNode left;

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        new Solution004().traverse(head);
    }

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
