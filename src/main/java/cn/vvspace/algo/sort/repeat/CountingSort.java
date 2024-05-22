package cn.vvspace.algo.sort.repeat;

import java.util.Arrays;

/**
 * 计数排序（counting sort）通过统计元素数量来实现排序，通常应用于整数数组。 <b>计数排序只适用于非负整数</b>
 * <p>
 * 时间复杂度为O(m+n)
 * <p>
 * 空间复杂度O(m+n)
 * <p>
 * 稳定排序：由于向 res 中填充元素的顺序是“从右向左”的，因此倒序遍历 nums 可以避免改变相等元素之间的相对位置，从而实现稳定排序。实际上，正序遍历 nums 也可以得到正确的排序结果，但结果是非稳定的。
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 2, 0, 4, 0, 2, 2, 4};
        new CountingSort().sortV1(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 1. 遍历数组，找出其中的最大数字，记为m ，然后创建一个长度为 的辅助数组 counter 。
     * <p>
     * 2. 借助 counter 统计 nums 中各数字的出现次数，其中 counter[num] 对应数字 num 的出现次数。统计方法很简单，只需遍历 nums（设当前数字为 num），每轮将 counter[num] 增加1即可。
     * <p>
     * 3. 由于 counter 的各个索引天然有序，因此相当于所有数字已经排序好了。接下来，我们遍历 counter ，根据各数字出现次数从小到大的顺序填入 nums 即可。
     *
     * @param nums nums
     */
    /*
        如果输入数据是对象，上述步骤 3. 就失效了。假设输入数据是商品对象，我们想按照商品价格（类的成员变量）对商品进行排序，而上述算法只能给出价格的排序结果。
        那么如何才能得到原数据的排序结果呢？我们首先计算 counter 的“前缀和”。顾名思义，索引 i 处的前缀和 prefix[i] 等于数组前 i 个元素之和：
     */
    public void sort(int[] nums) {
        int m = 0;
        for (int num : nums) {
            m = Math.max(m, num);
        }

        int[] counter = new int[m + 1];

        for (int num : nums) {
            counter[num]++;
        }

        int i = 0;
        for (int num = 0; num < m + 1; num++) {
            for (int j = 0; j < counter[num]; j++) {
                nums[i++] = num;
            }
        }
    }

    public void sortV1(int[] nums) {

        // 1. 统计数组最大元素 m
        int m = 0;
        for (int num : nums) {
            m = Math.max(m, num);
        }

        // 2. 统计各数字的出现次数
        // counter[num] 代表 num 的出现次数
        int[] counter = new int[m + 1];
        for (int num : nums) {
            counter[num]++;
        }

        // 3. 求 counter 的前缀和，将“出现次数”转换为“尾索引”
        // 即 counter[num]-1 是 num 在 res 中最后一次出现的索引
        for (int i = 0; i < m; i++) {
            counter[i + 1] += counter[i];
        }


        // 4. 倒序遍历 nums ，将各元素填入结果数组 res
        // 初始化数组 res 用于记录结果
        int n = nums.length;
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            res[counter[num] - 1] = num;// 将 num 放置到对应索引处
            counter[num]--;// 令前缀和自减 1 ，得到下次放置 num 的索引
        }

        // 使用结果数组 res 覆盖原数组 nums
        for (int i = 0; i < n; i++) {
            nums[i] = res[i];
        }
    }
}
