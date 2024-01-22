package cn.vvspace.algo.bt;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combinations/description/">77. 组合</a>
 * <p>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 */
public class Solution034 {

    public final List<List<Integer>> res = new LinkedList<>();
    public final Deque<Integer> track = new LinkedList<>();


    public static void main(String[] args) {
        int[] nums = new int[]{};
        Solution034 solution034 = new Solution034();
        System.out.println(solution034.combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        backtrack(nums, k, 0);
        return res;
    }

    private void backtrack(int[] nums, int k, int start) {
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, k, i + 1);
            track.removeLast();
        }
    }
}
