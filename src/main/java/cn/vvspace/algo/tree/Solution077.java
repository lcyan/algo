package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/cousins-in-binary-tree/description/">993. 二叉树的堂兄弟节点</a>
 * <p>
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <p>
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * <p>
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * <p>
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * <p>
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * <p>
 * 输出：false
 */
public class Solution077 {

    private TreeNode parentX;
    private TreeNode parentY;
    private int depthX;
    private int depthY;
    private int x;
    private int y;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        if (root == null) {
            return false;
        }

        traverse(root, 0, null);
        if (depthX == depthY && parentX != parentY) {
            return true;
        } else {
            return false;
        }
    }

    private void traverse(TreeNode root, int depth, TreeNode parent) {

        if (root == null) {
            return;
        }

        if (root.val == x) {
            parentX = parent;
            depthX = depth;
        }

        if (root.val == y) {
            parentY = parent;
            depthY = depth;
        }

        traverse(root.left, depth + 1, root);
        traverse(root.right, depth + 1, root);
    }
}
