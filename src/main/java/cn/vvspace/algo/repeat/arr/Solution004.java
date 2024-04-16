package cn.vvspace.algo.repeat.arr;

/**
 * <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/">167. 两数之和 II - 输入有序数组</a>
 */
public class Solution004 {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int curSum = numbers[left] + numbers[right];
            if (curSum == target) {
                return new int[]{left + 1, right + 1};
            }

            if (curSum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}
