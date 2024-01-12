package cn.vvspace.algo.arr;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/move-zeroes/description/">283. 移动零</a>
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class Solution012 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};

        moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return;
        }

        int newLen = removeDuplidate(nums, 0);

        for (int i = newLen; i < len; i++) {
            nums[i] = 0;
        }
    }

    private static int removeDuplidate(int[] nums, int x) {
        int slow = 0, fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != x) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }
}
