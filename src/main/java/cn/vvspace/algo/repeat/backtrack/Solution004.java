package cn.vvspace.algo.repeat.backtrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations/description/">46. 全排列</a>
 */
public class Solution004 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        Deque<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, track);
        return res;
    }

    private void backtrack(int[] nums, boolean[] used, Deque<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                track.add(nums[i]);
                used[i] = true;
                backtrack(nums, used, track);
                track.removeLast();
                used[i] = false;
            }
        }
    }
}
