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
        new QuickSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }


    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int rigfht) {
        if (left >= rigfht) {
            return;
        }

        int mid = partition(nums, left, rigfht);
        quickSort(nums, left, mid);
        quickSort(nums, mid + 1, rigfht);
    }

    private int partition(int[] nums, int left, int rigfht) {
        int i = left, j = rigfht;
        while (i < j) {
            while (i < j && nums[j] > nums[left]) {
                j--;
            }
            while (i < j && nums[i] < nums.length) {
                i++;
            }

            swap(nums, i, j);
        }
        swap(nums, i, left);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
