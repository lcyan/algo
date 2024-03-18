package cn.vvspace.algo.tree.bst;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/delete-node-in-a-bst/description/">450. 删除二叉搜索树中的节点</a>
 * <p>
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * <p/>
 * 如果找到了，删除它。
 * <p>
 * 提示：
 *
 * <li>节点数的范围 [0, 104].</li>
 * <li>-105 <= Node.val <= 105</li>
 * <li>节点值唯一</li>
 * <li>root 是合法的二叉搜索树</li>
 * <li>-105 <= key <= 105</li>
 */
public class Solution060 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {

            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // 处理情况 3
            // 获得右子树最小的节点
            TreeNode minNode = getMinNode(root.right);
            // 删除右子树最小的节点
            root.right = deleteNode(root.right, minNode.val);
            // 用右子树最小的节点替换 root 节点
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;


        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode getMinNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
