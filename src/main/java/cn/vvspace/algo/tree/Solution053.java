package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree-ii/description/">1644 题「二叉树的最近公共祖先 II」</a>
 * <p>
 * 给你输入一棵不含重复值的二叉树的，
 * 以及两个节点 p 和 q，如果 p 或 q 不存在于树中，则返回空指针，否则的话返回 p 和 q 的最近公共祖先节点。
 * <p>
 * 对于这道题来说，p 和 q 不一定存在于树中，所以你不能遇到一个目标值就直接返回
 */
public class Solution053 {

    // 用于记录 p 和 q 是否存在于二叉树中
    boolean foundP = false, foundQ = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = find(root, p.val, q.val);
        if (!foundP || !foundQ) {
            return null;
        } else {
            return result;
        }
    }

    private TreeNode find(TreeNode root, int var1, int var2) {
        if (root == null) {
            return null;
        }

        TreeNode left = find(root.left, var1, var2);
        TreeNode right = find(root.right, var1, var2);

        // 后序位置，判断当前节点是不是 LCA 节点
        if (left != null && right != null) {
            return root;
        }

        // 后序位置，判断当前节点是不是目标值
        if (root.val == var1 || root.val == var2) {
            // 找到了，记录一下
            if (root.val == var1) foundP = true;
            if (root.val == var2) foundQ = true;
            return root;
        }

        return left != null ? left : right;
    }
}
