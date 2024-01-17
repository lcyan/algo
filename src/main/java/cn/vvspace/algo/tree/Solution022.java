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
public class Solution022 {


    public int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-3);

        Solution022 solution022 = new Solution022();
        System.out.println(solution022.maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    public int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(traverse(root.left), 0);
        int rightSum = Math.max(traverse(root.right), 0);

        int currentSum = root.val + leftSum + rightSum;
        maxSum = Math.max(maxSum, currentSum);

        return root.val + Math.max(leftSum, rightSum);
    }

}
