package cn.vvspace.algo.repeat.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-ii/">40. 组合总和 II</a>
 */
public class Solution006 {

    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> track = new LinkedList<>();
    private int trackSum = 0;

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(new Solution006().combinationSum2(candidates, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
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
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            int val = candidates[i];
            track.add(val);
            trackSum += val;
            backtrack(candidates, i + 1, target);
            track.removeLast();
            trackSum -= val;
        }
    }
}
