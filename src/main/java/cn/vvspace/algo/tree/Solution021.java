package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/diameter-of-binary-tree/description/">543. 二叉树的直径</a>
 * <p>
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * <p>
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * <p>
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class Solution021 {

    private int maxDiameter = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, //
                new TreeNode(2, //
                        new TreeNode(5), //
                        new TreeNode(4)), //
                new TreeNode(3));

        Solution021 solution021 = new Solution021();
        System.out.println(solution021.diameterOfBinaryTree(root));
    }


    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return maxDiameter;
    }


    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        maxDiameter = Math.max(maxDiameter, leftMax + rightMax);

        traverse(root.left);
        traverse(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }

}
