package cn.vvspace.algo.repeat.backtrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="">全排列-元素可重不可复选</a>
 */
public class Solution007 {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> track = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println(new Solution007().permuteUnique(new int[]{1, 2, 2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used);
        return res;
    }

    private void backtrack(int[] nums, boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                // 如果前面的相邻相等元素没有用过，则跳过
                continue;
            }

            used[i] = true;
            track.add(nums[i]);
            backtrack(nums, used);
            track.removeLast();
            used[i] = false;
        }
    }
}
