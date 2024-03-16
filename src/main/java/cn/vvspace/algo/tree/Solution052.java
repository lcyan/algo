package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.HashSet;

/**
 * <a href="">1676. 二叉树的最近公共祖先 IV</a>
 * <p>
 * 需要注意的是，这两道题的题目都明确告诉我们这些节点必定存在于二叉树中
 */
public class Solution052 {

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<Integer> values = new HashSet<>();
        for (TreeNode node : nodes) {
            values.add(node.val);
        }
        return find(root, values);
    }

    private TreeNode find(TreeNode root, HashSet<Integer> values) {
        if (root == null) {
            return null;
        }

        if (values.contains(root.val)) {
            return root;
        }

        TreeNode left = find(root.left, values);
        TreeNode right = find(root.right, values);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
