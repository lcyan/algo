package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/closest-binary-search-tree-value">270. 最接近的二叉搜索树值</a>
 * <p>
 * 给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。如果有多个答案，返回最小的那个。
 */
public class Solution071 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(2), new TreeNode(5));
        System.out.println(new Solution071().closestValue(root, 4));
    }

    int res = 0;

    public int closestValue(TreeNode root, double target) {
        res = root.val;
        traverse(root, target);
        return res;
    }

    private void traverse(TreeNode root, double target) {
        if (root == null) {
            return;
        }


        if (root.val > target) {
            traverse(root.left, target);
            if (Math.abs(root.val - target) < Math.abs(res - target)) {
                res = root.val;
            }
        } else {
            if (Math.abs(root.val - target) < Math.abs(res - target)) {
                res = root.val;
            }
            traverse(root.right, target);
        }
    }
}
