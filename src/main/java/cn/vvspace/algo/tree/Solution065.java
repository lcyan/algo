package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-right-side-view/description/">199. 二叉树的右视图</a>
 * <p>
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 输入: [1,null,3]
 * <p>
 * 输出: [1,3]
 */
public class Solution065 {

    List<Integer> res = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, //
                new TreeNode(2, //
                        null, //
                        new TreeNode(5)), //
                new TreeNode(3));

        System.out.println(new Solution065().rightSideView(root));
    }

    public List<Integer> rightSideView(TreeNode root) {
        bfs(root);
        return res;
    }

    private void bfs(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int sz = q.size();

            TreeNode node = q.peek();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.pop();
                if (cur.right != null) {
                    q.offer(cur.right);
                }

                if (cur.left != null) {
                    q.offer(cur.left);
                }
            }
            res.add(node.val);
        }
    }

    int depth;

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (res.size() < depth) {
            // 每一层记录一次
            res.add(root.val);
        }
        dfs(root.right);
        dfs(root.left);
        depth--;
    }
}
