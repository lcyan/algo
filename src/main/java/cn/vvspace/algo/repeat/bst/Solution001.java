package cn.vvspace.algo.repeat.bst;

import cn.vvspace.algo.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree/">二叉树的最小深度</a>
 */
public class Solution001 {

    private int res = 0;

    int minDepth(TreeNode root) {
        bst(root);
        return res;
    }

    private void bst(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int sz = q.size();
            res += 1;
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) {
                    return;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
    }
}
