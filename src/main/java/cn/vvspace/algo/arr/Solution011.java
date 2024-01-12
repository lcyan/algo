package cn.vvspace.algo.arr;

/**
 * <a href="https://leetcode.cn/problems/remove-element/description/">27. 移除元素</a>
 * <p>
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,3,0,4]
 */
public class Solution011 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int newLen = removeElement(nums, 2);
        System.out.println(newLen);
        for (int i = 0; i < newLen; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int slow = 0, fast = 0;
        while (fast < len) {
            if (val != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
