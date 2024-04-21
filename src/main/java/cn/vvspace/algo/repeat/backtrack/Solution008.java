package cn.vvspace.algo.repeat.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum/description/">子集/组合（元素无重可复选）</a>
 */
public class Solution008 {

    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯的路径
    LinkedList<Integer> track = new LinkedList<>();
    // 记录 track 中的路径和
    int trackSum = 0;

    private void backtrack(int[] candidates, int start, int target) {
        if (trackSum == target) {
            res.add(new ArrayList<>(track));
            return;
        }

        if (trackSum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int val = candidates[i];
            track.add(val);
            trackSum += val;
            backtrack(candidates, i, target);
            track.removeLast();
            trackSum -= val;
        }
    }

    // candidates = [1,2,3], target = 3
    // [ [1,1,1],[1,2],[3] ]
    List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, target);
        return res;
    }
}
