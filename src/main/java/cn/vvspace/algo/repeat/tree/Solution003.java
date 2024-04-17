package cn.vvspace.algo.repeat.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/diameter-of-binary-tree/description/">543. 二叉树的直径</a>
 */
public class Solution003 {

    int res;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return res;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);

        int curMax = leftMaxDepth + rightMaxDepth;
        res = Math.max(res, curMax);

        return 1 + Math.max(leftMaxDepth, rightMaxDepth);

    }
}
