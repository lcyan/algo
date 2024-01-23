package cn.vvspace.algo.bt;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations/description/">46. 全排列</a>
 * <p>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * 排列（元素无重不可复选）
 */
public class Solution030 {

    List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Solution030 solution029 = new Solution030();
        System.out.println(solution029.permute(nums));
    }

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    private List<List<Integer>> permute(int[] nums) {
        Deque<Integer> trace = new LinkedList<>();
        boolean[] used = new boolean[nums.length + 1];
        backtrace(nums, trace, used);
        return res;
    }

    private void backtrace(int[] nums, Deque<Integer> trace, boolean[] used) {
        if (trace.size() == nums.length) {
            res.add(new LinkedList<>(trace));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            trace.add(nums[i]);
            used[i] = true;
            backtrace(nums, trace, used);
            trace.removeLast();
            used[i] = false;

        }
    }
}
