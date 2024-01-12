package cn.vvspace.algo.arr;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/">167. 两数之和 II - 输入有序数组</a>
 * <p>
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * <p>
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * <p>
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * <p>
 * 你所设计的解决方案必须只使用常量级的额外空间。
 * <p>
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 */
public class Solution013 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left <= right) {
            int compareRes = Integer.compare(numbers[left] + numbers[right], target);

            if (compareRes == 0) {
                return new int[]{left + 1, right + 1};
            } else if (compareRes > 0) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}
