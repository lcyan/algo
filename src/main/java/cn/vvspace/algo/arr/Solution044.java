package cn.vvspace.algo.arr;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/">34. 在排序数组中查找元素的第一个和最后一个位置</a>
 * <p>
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * <p>
 * 输出：[3,4]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * <p>
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * <p>
 * 输出：[-1,-1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * <p>
 * -109 <= nums[i] <= 109
 * <p>
 * nums 是一个非递减数组
 * <p>
 * -109 <= target <= 109
 */
public class Solution044 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2};
        Solution044 solution044 = new Solution044();
        int[] ranges = solution044.searchRange(nums, 3);
        System.out.println(Arrays.toString(ranges));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0, right = nums.length - 1;

        int[] result = new int[]{-1, -1};

        // left pos
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        if (left >= 0 && left < nums.length && nums[left] == target) {
            result[0] = left;
        }

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        if (right >= 0 && right < nums.length && nums[right] == target) {
            result[1] = right;
        }

        return result;
    }
}
