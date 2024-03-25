package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/find-bottom-left-tree-value/">513. 找树左下角的值</a>
 * <p>
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 */
public class Solution083 {

    // 记录二叉树的最大深度
    int maxDepth = 0;
    // 记录 traverse 递归遍历到的深度
    int depth = 0;
    TreeNode res = null;
    int resVal;

    public int findBottomLeftValue(TreeNode root) {
        traverse(root);
        return res.val;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        depth++;
        if (depth > maxDepth) {
            // 到最大深度时第一次遇到的节点就是左下角的节点
            maxDepth = depth;
            res = root;
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }

    private void bfs(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                res = q.poll();
                assert res != null;
                if (res.right != null) {
                    q.offer(res.right);
                }
                if (res.left != null) {
                    q.offer(res.left);
                }
            }
        }
    }
}
