package cn.vvspace.algo.repeat.binarysearch;

/**
 * <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/">34. 在排序数组中查找元素的第一个和最后一个位置</a>
 */
public class Solution002 {

    public int[] searchRange(int[] nums, int target) {
        int leftBound = left_bound(nums, target);
        int rightBound = right_bound(nums, target);
        return new int[]{leftBound, rightBound};
    }

    private int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) { // => [left = right + 1, right]
            int mid = left + (right - left) / 2;
            int cur = nums[mid];

            if (cur == target) {
                left = mid + 1; // => mid = left - 1;
            } else if (cur < target) {
                left = mid + 1;
            } else if (cur > target) {
                right = mid - 1;
            }
        }

        if (right < 0 || right >= nums.length) {
            return -1;
        }

        return nums[right] == target ? right : -1;
    }

    private int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        ;
        while (left <= right) { // => [left = right + 1, right]
            int mid = left + (right - left) / 2;
            int cur = nums[mid];
            if (cur == target) {
                right = mid - 1;
            } else if (cur < target) {
                left = mid + 1;
            } else if (cur > target) {
                right = mid - 1;
            }
        }

        // => return right -1;
        // => return left;

        if (left < 0 || left >= nums.length) {
            return -1;
        }

        return nums[left] == target ? left : -1;
    }
}
