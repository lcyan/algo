package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/range-sum-of-bst/">938. 二叉搜索树的范围和</a>
 * <p>
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 */
public class Solution095 {

    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        traverse(root, low, high);
        return sum;

    }

    // 定义：输入一个 BST，计算值落在 [low, high] 之间的元素之和
    public int rangeSumBSTV1(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val < low) {
            return rangeSumBSTV1(root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBSTV1(root.left, low, high);
        } else {
            return root.val + rangeSumBSTV1(root.left, low, high) + rangeSumBSTV1(root.right, low, high);
        }
    }

    // 遍历问题思路
    private void traverse(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
            traverse(root.left, low, high);
            traverse(root.right, low, high);
        }

        if (root.val < low) {
            rangeSumBST(root.right, low, high);
        }

        if (root.val > high) {
            rangeSumBST(root.left, low, high);
        }
    }

}
