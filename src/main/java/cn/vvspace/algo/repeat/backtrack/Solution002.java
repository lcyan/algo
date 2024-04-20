package cn.vvspace.algo.repeat.backtrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="">子集-元素无重不可复选</a>
 */
public class Solution002 {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> track = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println(new Solution002().subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        // 前序位置，每个节点的值都是一个子集
        res.add(new ArrayList<>(track));

        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}
