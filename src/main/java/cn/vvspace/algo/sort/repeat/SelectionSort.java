package cn.vvspace.algo.sort.repeat;

import java.util.Arrays;

/**
 * 选择排序（selection sort）的工作原理非常简单：开启一个循环，每轮从未排序区间选择最小的元素，将其放到已排序区间的末尾。
 * <p>
 * 时间复杂度：0(n^2)
 * <p>
 * 空间复杂度：O(1)
 * <p>
 * 非稳定性排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 5, 2, 3};
        new SelectionSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int mi = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[mi]) {
                    mi = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[mi];
            nums[mi] = tmp;
        }
    }
}
