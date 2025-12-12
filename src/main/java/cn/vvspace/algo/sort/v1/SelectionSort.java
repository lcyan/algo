package cn.vvspace.algo.sort.v1;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{8, 1, 6, 2, 5, 3};
        System.out.println("排序前：" + Arrays.toString(nums));
        sortV3(nums);
        System.out.println("排序后：" + Arrays.toString(nums));
    }

    public static void sort(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }

        }
    }

    public static void sortV2(int[] nums) {
        int n = nums.length;
        // sortedIndex 是一个分割线
        // 索引 < sortedIndex 的元素都是已排序的
        // 索引 >= sortedIndex 的元素都是未排序的
        // 初始化为 0，表示整个数组都是未排序的
        int sortedIndex = 0;

        // 找到未排序部分 [sortedIndex, n) 中的最小值
        int minIndex = sortedIndex;
        while (sortedIndex < n) {
            for (int i = sortedIndex + 1; i < n; i++) {
                if (nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
            }
            // 交换最小值和 sortedIndex 处的元素
            int tmp = nums[sortedIndex];
            nums[sortedIndex] = nums[minIndex];
            nums[minIndex] = tmp;

            sortedIndex++;
        }
    }

    // 选择排序（稳定版本）
    public static void sortV3(int[] nums) {
        int len = nums.length;
        int sortedIndex = 0;

        int minIndex = sortedIndex;
        while (sortedIndex < len) {

            for (int i = sortedIndex; i < len; i++) {
                if (nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
            }

            int minVal = nums[minIndex];
            for (int j = minIndex; j > sortedIndex; j--) {
                nums[j] = nums[j - 1];
            }
            nums[sortedIndex] = minVal;
            sortedIndex++;
        }
    }
}
