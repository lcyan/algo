package cn.vvspace.algo.arr;

/**
 * <a href="https://leetcode.cn/problems/binary-search/description/">704. 二分查找</a>
 * <p>
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * <p>
 * 输出: 4
 * <p>
 * 解释: 9 出现在 nums 中并且下标为 4
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * <p>
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 nums 中的所有元素是不重复的。
 * <p>
 * n 将在 [1, 10000]之间。
 * <p>
 * nums 的每个元素都将在 [-9999, 9999]之间。
 * <p>
 * 几个最常用的二分查找场景：寻找一个数、寻找左侧边界、寻找右侧边界。
 * <p>
 * 参考：<a href="https://labuladong.gitee.io/algo/di-ling-zh-bfe1b/wo-xie-le--3c789/#%E4%BA%8C%E3%80%81%E5%AF%BB%E6%89%BE%E5%B7%A6%E4%BE%A7%E8%BE%B9%E7%95%8C%E7%9A%84%E4%BA%8C%E5%88%86%E6%90%9C%E7%B4%A2">...</a>
 */
public class Solution043 {

    public static void main(String[] args) {
        Solution043 solution043 = new Solution043();
        int[] nums2 = new int[]{1, 2, 2, 2, 3};
        System.out.println(solution043.right_bound(nums2, 2));
        System.out.println(solution043.right_bound_v1(nums2, 2));
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1; // 注意

        while (left <= right) { // 注意
            int mid = left + (right - left) / 2;
            int current = nums[mid];
            if (current == target) {
                return mid;
            } else if (current > target) {
                right = mid - 1; // 注意
            } else {
                left = mid + 1; // 注意
            }
        }
        return -1;
    }

    /*
    binarySearch算法的缺陷
    比如说给你有序数组 nums = [1,2,2,2,3]，target 为 2，此算法返回的索引是 2，没错。
    但是如果我想得到 target 的左侧边界，即索引 1，
    或者我想得到 target 的右侧边界，即索引 3，这样的话此算法是无法处理的。
     */

    // 寻找左侧边界的二分搜索
    private int left_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length; // 注意


        // 3、为什么 left = mid + 1，right = mid ？和之前的算法不一样？
        // 答：这个很好解释，因为我们的「搜索区间」是 [left, right) 左闭右开，所以当 nums[mid] 被检测之后，下一步应该去 mid 的左侧或者右侧区间搜索，即 [left, mid) 或 [mid + 1, right)。
        while (left < right) { // 注意
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }

        if (left < 0 || left >= nums.length) {
            return -1;
        }

        return nums[left] == target ? left : -1;
    }

    private int left_bound_v1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // [left, right]

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cur = nums[mid];

            if (cur == target) {
                right = mid - 1;
            } else if (cur > target) {
                right = mid - 1;
            } else if (cur < target) {
                left = mid + 1;
            }
        }

        if (left >= nums.length) {
            return -1;
        }

        return nums[left] == target ? left : -1;
    }

    // 寻找右侧边界的二分搜索
    private int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length;
        // [left, right)

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        // 判断 target 是否存在于 nums 中
        // left - 1 索引越界的话 target 肯定不存在
        if (left - 1 < 0 || left - 1 >= nums.length) {
            return -1;
        }

        // 判断一下 nums[left - 1] 是不是 target
        return nums[left - 1] == target ? (left - 1) : -1;
    }

    private int right_bound_v1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }

        if (left - 1 < 0 || left - 1 >= nums.length) {
            return -1;
        }

        return nums[left - 1] == target ? left - 1 : -1;
    }
}
