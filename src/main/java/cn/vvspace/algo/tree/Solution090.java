package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/flip-equivalent-binary-trees/">951. 翻转等价二叉树</a>
 * <p>
 * 我们可以为二叉树 T 定义一个 翻转操作 ，如下所示：选择任意节点，然后交换它的左子树和右子树。
 * <p>
 * 只要经过一定次数的翻转操作后，能使 X 等于 Y，我们就称二叉树 X 翻转 等价 于二叉树 Y。
 * <p>
 * 这些树由根节点 root1 和 root2 给出。如果两个二叉树是否是翻转 等价 的函数，则返回 true ，否则返回 false 。
 */
public class Solution090 {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || //
                (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
