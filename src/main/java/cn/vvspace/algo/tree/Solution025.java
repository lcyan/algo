package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="">输入一棵二叉树的根节点，层序遍历这棵二叉树</a>
 */
public class Solution025 {

    public static void main(String[] args) {
        TreeNode root = //
                new TreeNode(1, //
                        new TreeNode(2, //
                                new TreeNode(5), //
                                new TreeNode(4, //
                                        new TreeNode(6), //
                                        new TreeNode(7))), //
                        new TreeNode(3, //
                                new TreeNode(8), //
                                new TreeNode(9)));

        Solution025 solution025 = new Solution025();
        solution025.levelTraverse(root);
    }

    private void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            int sz = q.size();
            // 从左到右遍历每一层的每个节点
            for (int i = 0; i < sz; i++) {
                TreeNode node = q.poll();
                System.out.println(node);
                // 将下一层节点放入队列
                assert node != null;
                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
    }
}
