package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/description/">LCR 143. 子结构判断</a>
 * <p>
 * 给定两棵二叉树 tree1 和 tree2，判断 tree2 是否以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。
 * <p>
 * 注意，空树 不会是以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。
 */
public class Solution097 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (A == null || B == null) {
            return false;
        }

        if (A.val == B.val && compareTree(A, B)) {
            return true;
        }

        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean compareTree(TreeNode a, TreeNode b) {

        if (b == null) {
            return true;
        }

        if (a == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return compareTree(a.left, b.left) && compareTree(a.right, b.right);
    }
}
