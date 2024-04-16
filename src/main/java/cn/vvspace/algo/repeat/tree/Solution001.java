package cn.vvspace.algo.repeat.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/">104. 二叉树的最大深度</a>
 */
public class Solution001 {

    int res = 0;
    int depth = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;

    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        depth++;
        if (root.left == null && root.right == null) {
            res = Math.max(depth, res);
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }

    private int traverseV1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = traverseV1(root.left);
        int rightMax = traverseV1(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }
}
