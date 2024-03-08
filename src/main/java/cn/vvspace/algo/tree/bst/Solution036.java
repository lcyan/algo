package cn.vvspace.algo.tree.bst;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/trim-a-binary-search-tree/">669. 修剪二叉搜索树</a>
 * <p>
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
 * <p>
 * 修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
 * <p>
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 */
public class Solution036 {

    public TreeNode trimBST(TreeNode root, int low, int high) {

        if (root == null) {
            return null;
        }

        if (root.val < low) {
            // 根据BST的定义，当前节点及左子树都不符合要求
            return trimBST(root.right, low, high);
        }

        if (root.val > high) {
            // 根据BST的定义，当前节点及右子树都不符合要求
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
