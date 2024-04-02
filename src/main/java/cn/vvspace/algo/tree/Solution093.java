package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/path-sum-ii/description/">113. 路径总和 II</a>
 * <p>
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 */
public class Solution093 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        traverse(root, sum, new LinkedList<>());
        return res;
    }

    // 分解问题思路
    public List<List<Integer>> pathSumV1(TreeNode root, int targetSum) {
        List<List<Integer>> rootAnswers = new LinkedList<>();
        if (root == null) {
            return rootAnswers;
        }

        // 如果是叶子节点并且值等于 targetSum，则找到一条路径
        if (root.left == null && root.right == null && root.val == targetSum) {
            LinkedList<Integer> path = new LinkedList<>();
            path.add(root.val);
            rootAnswers.add(path);
            return rootAnswers;
        }

        // 分别递归左右子树，找到子树中和为 targetSum - root.val 的路径
        List<List<Integer>> leftAnswers = pathSumV1(root.left, targetSum - root.val);
        List<List<Integer>> rightAnswers = pathSumV1(root.right, targetSum - root.val);

        // 左右子树的路径加上根节点，就是和为 targetSum 的路径
        for (List<Integer> answer : leftAnswers) {
            // 因为底层使用的是 LinkedList，所以这个操作的复杂度是 O(1)
            answer.add(0, root.val);
            rootAnswers.add(answer);
        }
        for (List<Integer> answer : rightAnswers) {
            // 因为底层使用的是 LinkedList，所以这个操作的复杂度是 O(1)
            answer.add(0, root.val);
            rootAnswers.add(answer);
        }

        return rootAnswers;
    }

    // 遍历二叉树
    private void traverse(TreeNode root, int sum, LinkedList<Integer> path) {
        if (root == null) {
            return;
        }

        int remain = sum - root.val;

        if (root.left == null && root.right == null) {
            if (remain == 0) {
                path.addLast(root.val);
                res.add(new LinkedList<>(path));
                path.removeLast();
                return;
            }
        }

        path.addLast(root.val);
        traverse(root.left, remain, path);
        path.removeLast();

        path.addLast(root.val);
        traverse(root.right, remain, path);
        path.removeLast();
    }
}
