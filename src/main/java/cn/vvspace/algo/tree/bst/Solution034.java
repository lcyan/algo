package cn.vvspace.algo.tree.bst;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/validate-binary-search-tree/description/">98. 验证二叉搜索树</a>
 * <p>
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * <p>
 * 节点的右子树只包含 大于 当前节点的数。
 * <p>
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Solution034 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min.val) {
            return false;
        }

        if (max != null && root.val >= max.val) {
            return false;
        }

        // 站在当前节点看，左子树的最大值的上限是当前节点，右子树的最小值下限是当前接地啊你
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
