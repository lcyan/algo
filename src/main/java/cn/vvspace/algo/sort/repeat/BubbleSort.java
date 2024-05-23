package cn.vvspace.algo.sort.repeat;

import java.util.Arrays;

/**
 * 冒泡排序（bubble sort）通过连续地比较与交换相邻元素实现排序。这个过程就像气泡从底部升到顶部一样，因此得名冒泡排序。
 * <p>
 * 如果某轮“冒泡”中没有执行任何交换操作，说明数组已经完成排序，可直接返回结果
 * <p>
 * 时间复杂度：0(n^2)
 * <p>
 * 空间复杂度：O(1)
 * <p>
 * 稳定性排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 5, 2, 3};
        new BubbleSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }


    public void sort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
