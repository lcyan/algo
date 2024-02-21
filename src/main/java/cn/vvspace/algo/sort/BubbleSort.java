package cn.vvspace.algo.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * <p>
 * 通过连续地比较与交换相邻元素实现排序
 * <p>
 * 时间复杂度O(n2)
 * <p>
 * 稳定排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 1, 6, 7, 2, 4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums) {
        int n = nums.length;


        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
