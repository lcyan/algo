package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/description/">235. 二叉搜索树的最近公共祖先</a>
 * <p>
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * 说明：
 *
 * <li>所有节点的值都是唯一的。</li>
 * <li>p、q 为不同节点且均存在于给定的二叉搜索树中。</li>
 */
public class Solution054 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 保证 val1 较小，val2 较大
        int var1 = Math.min(p.val, q.val);
        int var2 = Math.max(p.val, q.val);
        return find(root, var1, var2);
    }

    private TreeNode find(TreeNode root, int var1, int var2) {
        if (root == null) {
            return null;
        }

        if (root.val > var2) {
            return find(root.left, var1, var2);
        }

        if (root.val < var1) {
            return find(root.right, var1, var2);
        }

        // var1 <= root.val <= var2
        return root;
    }
}
