package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="">298. 二叉树最长连续序列</a>
 * <p>
 * 给你一棵指定的二叉树的根节点 root，请你计算其中最长连续序列路径的长度。
 * <p>
 * 最长连续序列路径是依次递增 1 的路径，该路径可以是从某个初始节点到树中任意节点，且必须从父节点到子节点，反过来是不可以的。
 * <p>
 * 输入：root = [1,null,3,2,4,null,null,null,5]
 * <p>
 * 输出：3
 * <p>
 * 解释：当中，最长连续序列是 3-4-5，所以返回结果为 3。
 */
public class Solution066 {

    private int maxLen = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, //
                null, //
                new TreeNode(3, //
                        new TreeNode(2), //
                        new TreeNode(4, //
                                null, //
                                new TreeNode(5))));

        System.out.println(new Solution066().longestConsecutive(root));
    }

    public int longestConsecutive(TreeNode root) {
        traverse(root, 1, Integer.MIN_VALUE);
        return maxLen;
    }

    private void traverse(TreeNode root, int len, int parentVal) {
        if (root == null) {
            return;
        }

        if (root.val == parentVal + 1) {
            len++;
        } else {
            len = 1;
        }

        maxLen = Math.max(maxLen, len);
        traverse(root.left, len, root.val);
        traverse(root.right, len, root.val);

    }
}
