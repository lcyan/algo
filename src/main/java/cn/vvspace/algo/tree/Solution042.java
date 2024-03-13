package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/invert-binary-tree/description/">226. 翻转二叉树</a>
 * <p>
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class Solution042 {

    public static void main(String[] args) {
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public TreeNode invertTreeV2(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTreeV2(root.left);
        TreeNode right = invertTreeV2(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
