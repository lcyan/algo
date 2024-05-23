package cn.vvspace.algo.sort.repeat;

import java.util.Arrays;

/**
 * 归并排序（merge sort）是一种基于分治策略的排序算法，包含图 11-10 所示的“划分”和“合并”阶段。
 * <p>
 * 划分阶段：通过递归不断地将数组从中点处分开，将长数组的排序问题转换为短数组的排序问题。
 * <p>
 * 合并阶段：当子数组长度为 1 时终止划分，开始合并，持续地将左右两个较短的有序数组合并为一个较长的有序数组，直至结束。
 * <p>
 * 时间复杂度：O(nlogn)
 * <p>
 * 空间复杂度：O(n)
 * <p>
 * 稳定性排序：在合并过程中，相等元素的次序保持不变。
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 5, 2, 3};
        new MergeSort().mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int i = left, j = mid + 1;
        int len = right - left + 1;
        int[] tmp = new int[len];

        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] > nums[j]) {
                tmp[k++] = nums[j++];
            } else {
                tmp[k++] = nums[i++];
            }
        }

        while (i <= mid) {
            tmp[k++] = nums[i++];
        }

        while (j <= right) {
            tmp[k++] = nums[j++];
        }

        for (int l = 0; l < len; l++) {
            nums[l + left] = tmp[l];
        }
    }


}
