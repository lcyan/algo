package cn.vvspace.algo.sort.v1;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 3, 2};
        System.out.println("排序前：" + Arrays.toString(nums));
        sort(nums);
        System.out.println("排序后：" + Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        int len = nums.length;
        int sortedIndex = 0;

        while (sortedIndex < len) {
            boolean swapped = false;
            for (int i = len - 1; i > sortedIndex; i--) {
                if (nums[i] < nums[i - 1]) {
                    int tmp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = tmp;

                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            sortedIndex++;
        }

    }
}
