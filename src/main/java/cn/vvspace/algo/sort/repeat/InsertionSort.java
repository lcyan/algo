package cn.vvspace.algo.sort.repeat;

import java.util.Arrays;

/**
 * 插入排序（insertion sort）是一种简单的排序算法，它的工作原理与手动整理一副牌的过程非常相似。
 * <p>
 * 具体来说，我们在未排序区间选择一个基准元素，将该元素与其左侧已排序区间的元素逐一比较大小，并将该元素插入到正确的位置。
 * <p>
 * 时间复杂度：0(n^2)
 * <p>
 * 空间复杂度：O(1)
 * <p>
 * 稳定性排序
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 5, 2, 3};
        new InsertionSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int base = nums[i], j = i - 1;
            while (j >= 0 && nums[j] > base) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = base;
        }
    }
}
