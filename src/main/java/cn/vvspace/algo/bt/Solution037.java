package cn.vvspace.algo.bt;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations-ii/description/">47.全排列 II</a>
 *<p>
 * 排列（元素可重不可复选）
 * <p>
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Solution037 {

    private final List<List<Integer>> res = new LinkedList<>();
    private final Deque<Integer> track = new LinkedList<>();

    public static void main(String[] args) {
        Solution037 solution037 = new Solution037();
        int[] nums = new int[]{1, 1, 2};
        System.out.println(solution037.permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length + 1];
        Arrays.sort(nums);
        backtrackV2(nums, used);
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

            // 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                // 如果前面的相邻相等元素没有用过，则跳过
                continue;
            }


            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, used);
            track.removeLast();
            used[i] = false;
        }
    }

    private void backtrackV2(int[] nums, boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        // 记录之前树枝上元素的值
        // 题目说 -10 <= nums[i] <= 10，所以初始化为特殊值
        int prevNum = -666;
        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            if (prevNum == nums[i]) {
                continue;
            }

            track.add(nums[i]);
            used[i] = true;
            // 记录这条树枝上的值
            prevNum = nums[i];
            backtrackV2(nums, used);
            track.removeLast();
            used[i] = false;
        }
    }
}
