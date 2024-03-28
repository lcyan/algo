package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/">124. 二叉树中的最大路径和</a>
 * <p>
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class Solution091 {

    private int maxPathSum;

    public static void main(String[] args) {
        TreeNode root = TreeNode.of(1, TreeNode.of(2), TreeNode.of(3));
        System.out.println(new Solution091().maxPathSum(root));
    }

    // [1,2,3]
    public int maxPathSum(TreeNode root) {
        if (root != null) {
            maxPathSum = root.val;
        }
        oneSizeMax(root);
        return maxPathSum;
    }

    // 定义：计算从根节点 root 为起点的最大单边路径和
    private int oneSizeMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = Math.max(oneSizeMax(root.left), 0);
        int rightMax = Math.max(oneSizeMax(root.right), 0);
        maxPathSum = Math.max(maxPathSum, leftMax + rightMax + root.val);
        return Math.max(leftMax, rightMax) + root.val;
    }
}
