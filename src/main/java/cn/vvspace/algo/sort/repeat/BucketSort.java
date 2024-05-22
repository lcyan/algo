package cn.vvspace.algo.sort.repeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 前述几种排序算法都属于“基于比较的排序算法”，它们通过比较元素间的大小来实现排序。此类排序算法的时间复杂度无法超越 。
 * <p>
 * 接下来，我们将探讨几种“非比较排序算法”，它们的时间复杂度可以达到线性阶。
 * <p>
 * 桶排序（bucket sort）是分治策略的一个典型应用。它通过设置一些具有大小顺序的桶，每个桶对应一个数据范围，将数据平均分配到各个桶中；然后，在每个桶内部分别执行排序；最终按照桶的顺序将所有数据合并。
 * <p>
 * 时间复杂度为O(n+1) ：假设元素在各个桶内平均分布，那么每个桶内的元素数量为n/k。
 * <p>
 * 假设排序单个桶使用O(n/k * logn/k)时间，则排序所有桶使用0(nlogn/k)时间。
 * <p>
 * 当桶数量k比较大时，时间复杂度则趋向于O(n)。合并结果时需要遍历所有桶和元素，花费O(k+n)时间。 <p>
 * <p>
 * 空间复杂度为 O(k+n): 、非原地排序：需要借助K个桶和总共n个元素的额外空间。
 * <p>
 * 桶排序是否稳定取决于排序桶内元素的算法是否稳定。
 */
public class BucketSort {

    public static void main(String[] args) {
        float[] nums = new float[]{0.01f, 0.08f, 0.42f, 0.76f, 0.33f};
        new BucketSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 考虑一个长度为 的数组，其元素是范围[0, 1)内的浮点数。
     * <p>
     * 1. 初始化k个桶，将 个元素分配到 个桶中。
     * <p>
     * 2. 对每个桶分别执行排序（这里采用编程语言的内置排序函数）。
     * <p>
     * 3. 按照桶从小到大的顺序合并结果。
     *
     * @param nums nums
     */
    public void sort(float[] nums) {
        // 0. 初始化 k = n/2 个桶，预期向每个桶分配 2 个元素
        int k = nums.length / 2;
        List<List<Float>> buckets = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            buckets.add(new ArrayList<>());
        }

        // 1. 将数组元素分配到各个桶中
        for (float num : nums) {
            // 输入数据范围为 [0, 1)，使用 num * k 映射到索引范围 [0, k-1]
            int i = (int) (num * k);
            // 将 num 添加进桶 i
            buckets.get(i).add(num);
        }

        // 2. 对各个桶执行排序
        for (List<Float> bucket : buckets) {
            // 使用内置排序函数，也可以替换成其他排序算法
            Collections.sort(bucket);
        }

        // 3. 遍历桶合并结果
        int i = 0;
        for (List<Float> bucket : buckets) {
            for (float num : bucket) {
                nums[i++] = num;
            }
        }
    }
}
