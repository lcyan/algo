package cn.vvspace.algo.repeat.arr;

import cn.vvspace.algo.base.ListNode;

/**
 * 删除有序数组中的重复项
 */
public class Solution008 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(new Solution008().removeDuplicates(nums));
    }

    // 1, 2, 2, 3, 5 => 1, 2, 3, 5
    int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int slow = 0, fast = 0;
        int len = nums.length;


        while (fast < len) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }

        return slow + 1;
    }


    // 删除排序列表中的重复元素
    ListNode deleteDuplicates(ListNode head) {
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
