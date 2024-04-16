package cn.vvspace.algo.repeat.arr;

/**
 * <a href="https://leetcode.cn/problems/remove-element/description/">27. 移除元素</a>
 */
public class Solution002 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        System.out.println(new Solution002().removeElement(nums, 3));
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
