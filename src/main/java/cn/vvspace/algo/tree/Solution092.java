package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/path-sum/description/">112. 路径总和</a>
 * <p>
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 */
public class Solution092 {

    private int pathSum;
    private boolean found;
    private int targetSum;

    public boolean hasPathSumV1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                return true;
            }
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        this.targetSum = targetSum;
        traverse(root);
        return found;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        pathSum += root.val;
        if (root.left == null && root.right == null) {
            if (pathSum == targetSum) {
                found = true;
            }
        }
        traverse(root.left);
        traverse(root.right);
        pathSum -= root.val;
    }
}
