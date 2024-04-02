package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/increasing-order-search-tree/description/">897. 递增顺序搜索树</a>
 * <p>
 * 给你一棵二叉搜索树的 root ，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 */
public class Solution094 {

    TreeNode dummy = new TreeNode(-1);

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode treeNode = new Solution094().increasingBSTV1(root);
        System.out.println(treeNode);
    }

    // 分解问题思路
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = increasingBST(root.left);
        TreeNode right = increasingBST(root.right);

        root.left = null;
        root.right = right;

        if (left == null) {
            return root;
        }

        TreeNode p = left;
        while (p.right != null) {
            p = p.right;
        }

        p.right = root;
        return left;
    }

    // 遍历思路
    public TreeNode increasingBSTV1(TreeNode root) {
        TreeNode p = this.dummy;
        traverse(root);
        return p.right;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        dummy.right = new TreeNode(root.val);
        dummy = dummy.right;
        traverse(root.right);
    }
}
