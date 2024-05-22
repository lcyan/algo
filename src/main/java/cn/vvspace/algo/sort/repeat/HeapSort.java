package cn.vvspace.algo.sort.repeat;

import java.util.Arrays;

/**
 * 堆排序（heap sort）是一种基于堆数据结构实现的高效排序算法。我们可以利用已经学过的“建堆操作”和“元素出堆操作”实现堆排序。
 * <p>
 * 输入数组并建立小顶堆，此时最小元素位于堆顶。
 * <p>
 * 不断执行出堆操作，依次记录出堆元素，即可得到从小到大排序的序列。
 * <p>
 * 以上方法虽然可行，但需要借助一个额外数组来保存弹出的元素，比较浪费空间。在实际中，我们通常使用一种更加优雅的实现方式。
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 3, 5, 2, 7, 6};
        new HeapSort().heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }


    /* 堆的长度为 n ，从节点 i 开始，从顶至底堆化 */
    public void siftDown(int[] nums, int n, int i) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int mi = i;
            if (left < n && nums[left] > nums[mi]) {
                mi = left;
            }

            if (right < n && nums[right] > nums[mi]) {
                mi = right;
            }

            if (mi == i) {
                break;
            }

            int tmp = nums[i];
            nums[i] = nums[mi];
            nums[mi] = tmp;
            i = mi;
        }
    }

    /**
     * 1. 输入数组并建立大顶堆。完成后，最大元素位于堆顶。
     * <p>
     * 2. 将堆顶元素（第一个元素）与堆底元素（最后一个元素）交换。完成交换后，堆的长度减 ，已排序元素数量加 。
     * <p>
     * 3. 从堆顶元素开始，从顶到底执行堆化操作（sift down）。完成堆化后，堆的性质得到修复。
     * <p>
     * 4. 循环执行第 2. 步和第 3. 步。循环 轮后，即可完成数组排序。
     *
     * @param nums nums
     */

    public void heapSort(int[] nums) {
        // 建堆操作：堆化除叶节点以外的其他所有节点
        // parent = (i-1)/2 => i为下标
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            siftDown(nums, nums.length, i);
        }
        // 从堆中提取最大元素，循环 n-1 轮
        for (int i = nums.length - 1; i > 0; i--) {
            // 交换根节点与最右叶节点（交换首元素与尾元素）
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            // 以根节点为起点，从顶至底进行堆化
            siftDown(nums, i, 0);
        }
    }
}
