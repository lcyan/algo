package cn.vvspace.algo.bt;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/subsets/description/">78. 子集</a>
 * <p>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 子集（元素无重不可复选）
 */
public class Solution033 {

    private final List<List<Integer>> res = new LinkedList<>();
    private final Deque<Integer> track = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        Solution033 solution033 = new Solution033();
        System.out.println(solution033.subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    /* 如果把根节点作为第 0 层，将每个节点和根节点之间树枝上的元素作为该节点的值，那么第 n 层的所有节点就是大小为 n 的所有子集。 */
    private void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));
        // 通过保证元素之间的相对顺序不变来防止出现重复的子集。
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.add(nums[i]);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }
}
