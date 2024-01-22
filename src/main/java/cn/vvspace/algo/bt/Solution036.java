package cn.vvspace.algo.bt;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-ii/description/">40. 组合总和 II</a>
 * <p>
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * <p>
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class Solution036 {

    private final List<List<Integer>> res = new LinkedList<>();
    private final Deque<Integer> track = new LinkedList<>();
    private int trackSum = 0;

    public static void main(String[] args) {
        int[] nums = new int[]{10, 1, 2, 7, 6, 1, 5};
        Solution036 solution036 = new Solution036();
        System.out.println(solution036.combinationSum2(nums, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrace(candidates, target, 0);
        return res;
    }

    private void backtrace(int[] candidates, int target, int start) {
        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            return;
        }

        if (trackSum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int item = candidates[i];
            if (i > start && item == candidates[i - 1]) {
                continue;
            }
            track.add(item);
            trackSum += item;
            backtrace(candidates, target, i + 1);
            track.removeLast();
            trackSum -= item;
        }
    }
}
