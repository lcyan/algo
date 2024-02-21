package cn.vvspace.algo.sort;

import java.util.Arrays;

/**
 * 选择排序
 * <p>
 * 每次从未排序的列表中选择最小的元素，放到已排序列表的末尾
 * <p>
 * 时间复杂度O(n2)
 * <p>
 * 不稳定排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 1, 6, 7, 2, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int k = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[k]) {
                    k = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[k];
            arr[k] = tmp;
        }
    }
}
