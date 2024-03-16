package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/">236. 二叉树的最近公共祖先</a>
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：
 * <p>
 * “对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 提示：
 * <li>树中节点数目在范围 [2, 105] 内。</li>
 * <li>-109 <= Node.val <= 109</li>
 * <li>所有 Node.val 互不相同 。</li>
 * <li>p != q</li>
 * <li>p 和 q 均存在于给定的二叉树中。</li>
 */
public class Solution051 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p, q);
    }

    private TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // 情况二：p是q的祖先或q是p的祖先
        // 因为题目说了 p 和 q 一定存在于二叉树中(这点很重要），
        // 所以即便我们遇到 q 就直接返回，根本没遍历到 p，也依然可以断定 p 在 q 底下，q 就是 LCA 节点
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);

        // 情况一：p,q有共同祖先x
        // 题目已说明节点值无重复
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
