package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/">104. 二叉树的最大深度</a>
 * <p>
 * 给定一个二叉树 root ，返回其最大深度。
 * <p>
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数
 */
public class Solution018 {

    public static int depth = 0;
    public static int res = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(maxDepthV2(root));
    }


    public static int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    public static int maxDepthV2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 利用定义，计算左右子树的最大深度
        int leftMax = maxDepthV2(root.left);
        int rightMax = maxDepthV2(root.right);
        // 整棵树的最大深度等于左右子树的最大深度取最大值，
        // 然后再加上根节点自己
        return Math.max(leftMax, rightMax) + 1;
    }

    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (root.left == null && root.right == null) {
            res = Math.max(res, depth);
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}
