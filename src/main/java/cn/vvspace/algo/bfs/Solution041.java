package cn.vvspace.algo.bfs;

import cn.vvspace.algo.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/">111. 二叉树的最小深度</a>
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 */
public class Solution041 {

    public static void main(String[] args) {
        TreeNode root = //
                new TreeNode(3, //
                        new TreeNode(9), //
                        new TreeNode(20, //
                                new TreeNode(15), //
                                new TreeNode(7)));

        TreeNode rootV2 = //
                new TreeNode(2, //
                        null, //
                        new TreeNode(3, //
                                null, //
                                new TreeNode(4, //
                                        null, //
                                        new TreeNode(5, //
                                                null, //
                                                new TreeNode(6, null, null)))));

        TreeNode rootV3 = //
                new TreeNode(1, //
                        new TreeNode(2, //
                                new TreeNode(4), //
                                new TreeNode(5)), //
                        new TreeNode(3) //
                );

        Solution041 solution041 = new Solution041();
        System.out.println(solution041.minDepth(rootV3));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                TreeNode node = q.poll();
                assert node != null;
                if (node.left == null && node.right == null) {
                    return depth;
                }

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }

            }
            depth++;
        }
        return depth;
    }
}
