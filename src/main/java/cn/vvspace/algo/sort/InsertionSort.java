package cn.vvspace.algo.sort;

import java.util.Arrays;

/**
 * 插入排序
 * <p>
 * 具体来说，我们在未排序区间选择一个基准元素，将该元素与其左侧已排序区间的元素逐一比较大小，并将该元素插入到正确的位置。
 * <p>
 * 时间复杂度O(n2)
 * <p>
 * 稳定排序
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 1, 6, 7, 2, 4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int base = nums[i], j = i - 1;
            while (j >= 0 && nums[j] > base) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = base;
        }
    }
}
