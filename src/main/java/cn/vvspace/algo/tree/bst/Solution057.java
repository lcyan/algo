package cn.vvspace.algo.tree.bst;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/convert-bst-to-greater-tree/description/">538. 把二叉搜索树转换为累加树</a>
 * <p>
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * <li>节点的左子树仅包含键 小于 节点键的节点。</li>
 * <li>节点的右子树仅包含键 大于 节点键的节点。</li>
 * <li>左右子树也必须是二叉搜索树。</li>
 * <p>
 * 提示：
 *
 * <li>树中的节点数介于 0 和 104 之间。</li>
 * <li>每个节点的值介于 -104 和 104 之间。</li>
 * <li>树中的所有值 互不相同 。</li>
 * <li>给定的树为二叉搜索树。</li>
 */
public class Solution057 {

    private int sum = 0;

    // 对于一个节点来说，确实右子树都是比它大的元素，但问题是它的父节点也可能是比它大的元素
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }


}
