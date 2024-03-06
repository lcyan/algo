package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/delete-node-in-a-bst/description/">450. 删除二叉搜索树中的节点</a>
 * <p>
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * <p>
 * 如果找到了，删除它。
 */
public class Solution031 {

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // found
            // 情况一：root为叶子结点
            // 情况二：root左右节点有一个为空
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // 情况三：root的左右节点都非空
                // 找到root左子树的最大值或右子树的最小值替换root节点
                TreeNode leftMax = maxNode(root.left);
                root.left = removeLeftMax(root.left);
                leftMax.left = root.left;
                leftMax.right = root.right;
                root = leftMax;
            }


        }

        return root;
    }

    private TreeNode removeLeftMax(TreeNode root) {
        if (root.right == null) {
            return root.left;
        }
        root.right = removeLeftMax(root.right);
        return root;
    }

    private TreeNode maxNode(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}
