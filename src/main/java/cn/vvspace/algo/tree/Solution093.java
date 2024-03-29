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
        if (root == null) return res;
        traverse(root, sum, new LinkedList<>());
        return res;
    }

    // 遍历二叉树
    private void traverse(TreeNode root, int sum, LinkedList<Integer> path) {
        if (root == null) return;

        int remain = sum - root.val;

        if (root.left == null && root.right == null) {
            if (remain == 0) {
                // 找到一条路径
                path.addLast(root.val);
                res.add(new LinkedList<>(path));
                path.removeLast();
            }
            return;
        }

        // 维护路径列表
        path.addLast(root.val);
        traverse(root.left, remain, path);
        path.removeLast();

        path.addLast(root.val);
        traverse(root.right, remain, path);
        path.removeLast();
    }
}
