package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="">输入一棵二叉树的根节点，层序遍历这棵二叉树</a>
 */
public class Solution025 {

    List<List<Integer>> res = new ArrayList<>();

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
        System.out.println(solution025.levelTraverseV2(root));
    }

    private List<List<Integer>> levelTraverseV2(TreeNode root) {
        if (root == null) {
            return null;
        }
        // root 视为第 0 层
        traverse(root, 0);
        return res;
    }

    // 通过前序遍历实现层次遍历
    // 这个解法是依赖前序遍历自顶向下、自左向右的顺序特点得到了正确的结果。
    private void traverse(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // 前序位置，看看是否已经存储 depth 层的节点了
        if (res.size() <= depth) {
            // 第一次进入 depth 层
            res.add(new LinkedList<>());
        }
        // 前序位置，在 depth 层添加 root 节点的值
        res.get(depth).add(root.val);
        traverse(root.left, depth + 1);
        traverse(root.right, depth + 1);
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
