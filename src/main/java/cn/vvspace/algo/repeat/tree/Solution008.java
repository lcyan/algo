package cn.vvspace.algo.repeat.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="">回溯算法-全排列</a>
 */
public class Solution008 {
    public static void main(String[] args) {
        System.out.println(new Solution008().permute(new int[]{1, 2, 3}));
    }

    List<List<Integer>> res = new ArrayList<>();

    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        // 「路径」中的元素会被标记为 true，避免重复使用
        boolean[] used = new boolean[nums.length];
        backtrack(nums, track, used);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
    // 结束条件：nums 中的元素全都在 track 中出现
    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            track.addLast(nums[i]);
            used[i] = true;
            backtrack(nums, track, used);
            track.removeLast();
            used[i] = false;
        }
    }
}
