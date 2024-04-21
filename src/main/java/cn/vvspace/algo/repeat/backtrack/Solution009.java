package cn.vvspace.algo.repeat.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="">排列（元素无重可复选）</a>
 */
public class Solution009 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new Solution009().permuteRepeat(nums));
    }

    public List<List<Integer>> permuteRepeat(int[] nums) {
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int num : nums) {
            track.add(num);
            backtrack(nums);
            track.removeLast();
        }
    }
}
