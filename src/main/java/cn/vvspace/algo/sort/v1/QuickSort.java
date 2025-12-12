package cn.vvspace.algo.sort.v1;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 7, 2, 8, 5, 3, 6, 9};
        System.out.println("排序前：" + Arrays.toString(nums));
        sort(nums);
        System.out.println("排序后：" + Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public static void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int p = partition(nums, lo, hi);
        sort(nums, lo, p - 1);
        sort(nums, p + 1, hi);
    }

    private static int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];

        int i = lo + 1, j = hi;

        int k = 1;
        while (i <= j) {
            while (i < hi && nums[i] < pivot) i++;
            while (j > lo && nums[j] > pivot) j--;
            if (i >= j) {
                break;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            System.out.println("第" + k + "轮：" + Arrays.toString(nums));
            k++;
        }

        int tmp = nums[lo];
        nums[lo] = nums[j];
        nums[j] = tmp;

        return j;
    }
}
