package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/sum-of-left-leaves/description/">404. 左叶子之和</a>
 * <p>
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 * <p>
 * 输入: root = [3,9,20,null,null,15,7]
 * <p>
 * 输出: 24
 * <p>
 * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class Solution072 {

    int res;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(new Solution072().sumOfLeftLeaves(root));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }

        traverse(root.left);
        traverse(root.right);

    }
}
