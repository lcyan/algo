package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/symmetric-tree/description/">101. 对称二叉树</a>
 * <p>
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class Solution089 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
