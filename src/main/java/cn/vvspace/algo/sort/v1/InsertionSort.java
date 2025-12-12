package cn.vvspace.algo.sort.v1;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 3, 2};
        System.out.println("排序前：" + Arrays.toString(nums));
        sort(nums);
        System.out.println("排序后：" + Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        int n = nums.length;
        int sortedIndex = 0;

        while (sortedIndex < n) {

            for (int i = sortedIndex; i > 0; i--) {
                if (nums[i] < nums[i - 1]) {
                    int tmp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = tmp;
                } else {
                    break;
                }
            }

            sortedIndex++;
        }
    }
}
