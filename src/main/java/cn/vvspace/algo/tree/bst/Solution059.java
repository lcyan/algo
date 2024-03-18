package cn.vvspace.algo.tree.bst;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/search-in-a-binary-search-tree/description/">700. 二叉搜索树中的搜索</a>
 * <p>
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * <p>
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 */
public class Solution059 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val > root.val) {
            return searchBST(root.right, val);
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        }

        return root;
    }
}
