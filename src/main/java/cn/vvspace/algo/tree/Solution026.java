package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/find-largest-value-in-each-tree-row/description/">515. 在每个树行中找最大值</a>
 * <p>
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 */
public class Solution026 {

    public static void main(String[] args) {
        TreeNode root = //
                new TreeNode(1, //
                        new TreeNode(3, //
                                new TreeNode(5), //
                                new TreeNode(3)), //
                        new TreeNode(2, //
                                null, //
                                new TreeNode(9)));

        Solution026 solution026 = new Solution026();
        System.out.println(solution026.largestValues(root));
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        if (root == null) {
            return integers;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int sz = q.size();
            int levelMax = Integer.MIN_VALUE;
            for (int i = 0; i < sz; i++) {
                TreeNode node = q.poll();

                assert node != null;
                levelMax = Math.max(levelMax, node.val);

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            integers.add(levelMax);
        }
        return integers;
    }
}
