package cn.vvspace.algo.sort.repeat;

import java.util.Arrays;

/**
 * 快速排序（quick sort）是一种基于分治策略的排序算法，运行高效，应用广泛。
 * <p>
 * 快速排序的核心操作是“哨兵划分”，其目标是：选择数组中的某个元素作为“基准数”，将所有小于基准数的元素移到其左侧，而大于基准数的元素移到其右侧。具体来说，哨兵划分的流程如图 11-8 所示。
 * <p>
 * 时间复杂度：O(nlogn)
 * <p>
 * 空间复杂度：O(n)
 * <p>
 * 非稳定性排序：在哨兵划分的最后一步，基准数可能会被交换至相等元素的右侧。
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 5, 2, 3};
        new QuickSort().quickSortV1(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }


    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    // 尾递归优化
    public void quickSortV1(int[] nums, int left, int right) {
        while (left < right) {
            int pivot = partition(nums, left, right);
            if (pivot - left < right - pivot) {
                quickSortV1(nums, left, pivot - 1);
                left = pivot + 1;
            } else {
                quickSortV1(nums, pivot + 1, right);
                right = pivot - 1;
            }
        }
    }

    // 左子数组任意元素 <= 基准数 <= 右子数组任意元素
    // 当我们以最左端元素为基准数时，必须先“从右往左查找”再“从左往右查找”
    public int partition(int[] nums, int left, int right) {
        int i = left, j = right;

        while (i < j) {
            while (i < j && nums[j] > nums[left]) {
                j--;
            }
            while (i < j && nums[i] < nums[left]) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, left, i);
        return i;
    }


    public void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

}
