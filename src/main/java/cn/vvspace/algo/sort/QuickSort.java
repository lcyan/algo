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
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 1, 6, 7, 2, 4};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            System.out.printf("开始排从【arr[%d]】到【arr[%d]】数据\n", left, right);
            int pivot = partition(arr, left, right);
            System.out.printf("返回的基准位置是：%d,分区排序后的结果：%s\n", pivot, Arrays.toString(arr));
            // 基准元素一定比左边的数大，所以左边分区最大值是：pivot - 1，分区范围是[left, pivot - 1]
            quickSort(arr, left, pivot - 1);
            // 基准元素一定比右边的数小，所以右边分区最小值是：pivot + 1，分区范围是[pivot + 1, right]
            quickSort(arr, pivot + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        // 定义基准元素
        int pivotValue = arr[left];
        // 遍历（条件就是分区左边索引小于右边索引）
        while (left < right) {
            // 从右边right开始遍历，找到一个数比基准数小
            while (left < right && arr[right] >= pivotValue) {
                // 未找到，继续往前找
                right--;
            }
            // 找到了，则把找到小值放到此时左边索引的位置
            // 第一次进入时,基准元素已存放到临时值pivotValue了，第一次就相当于放到基准位置了，同时，arr[right]也腾出了一个位置
            arr[left] = arr[right];
            // 从左边left开始遍历，找到一个数比基准数大
            while (left < right && arr[left] <= pivotValue) {
                // 未找到，继续往后找
                left++;
            }
            // 找到了，则把找到大值放到此时右边索引的位置（也就是腾出的位置）
            // 同时，arr[left]也腾出了一个位置
            arr[right] = arr[left];
        }
        // left等于right说明遍历结束了，把基准元素插入到腾出的位置，也就是arr[left]或者arr[right]
        arr[left] = pivotValue;
        // 返回基准元素插入的位置
        return left;
    }

}
