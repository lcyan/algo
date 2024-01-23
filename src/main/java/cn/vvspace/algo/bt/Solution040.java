package cn.vvspace.algo.bt;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum/description/">39. 组合总和</a>
 * <p>
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * <p>
 * 示例 2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * <p>
 * 示例 3：
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * candidates 的所有元素 互不相同
 * 1 <= target <= 40
 * <p>
 * 子集/组合（元素无重可复选）
 */
public class Solution040 {

    private final List<List<Integer>> res = new LinkedList<>();
    private final Deque<Integer> track = new LinkedList<>();
    private int trackSum = 0;

    public static void main(String[] args) {
        Solution040 solution040 = new Solution040();
        int[] candidates = new int[]{2, 3, 5};
        System.out.println(solution040.combinationSum(candidates, 8));

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        boolean[] used = new boolean[candidates.length + 1];
        Arrays.sort(candidates);
        backtrack(candidates, 0, 8);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target) {

        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            return;
        }

        if (trackSum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            track.add(candidates[i]);
            trackSum += candidates[i];
            backtrack(candidates, i, target);
            track.removeLast();
            trackSum -= candidates[i];
        }
    }
}
