package cn.vvspace.algo.sort;

import java.util.Arrays;

/**
 * 快速排序
 * <p>
 * 每次从未排序的列表中选择最小的元素，放到已排序列表的末尾
 * <p>
 * 时间复杂度O(n2)
 * <p>
 * 非稳定排序
 */
public class QuickSortV2 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 1, 6, 7, 2, 4};
        QuickSortV2 quickSort = new QuickSortV2();
        quickSort.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partiton(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private int partiton(int[] arr, int low, int high) {
        int pivot = arr[high]; // 选择最后一个元素作为分区点
        int i = low - 1; // i指向小于分区点的元素
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j); // 将小于分区点的元素交换到左侧
            }
        }
        swap(arr, i + 1, high);  // 将分区点放到正确的位置
        return i + 1; // 返回分区点的索引
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
