package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="">输入一棵二叉树的根节点，层序遍历这棵二叉树</a>
 */
public class Solution025 {

    private final List<List<Integer>> res = new LinkedList<>();

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
        System.out.println(solution025.levelTraverseV3(root));
    }


    private void levelTraverseV1(TreeNode root) {
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

    // ----------------------------------

    private List<List<Integer>> levelTraverseV2(TreeNode root) {
        if (root == null) {
            return null;
        }
        // root 视为第 0 层
        traverseV2(root, 0);
        return res;
    }

    // 通过前序遍历实现层次遍历
    // 这个解法是依赖前序遍历自顶向下、自左向右的顺序特点得到了正确的结果。
    private void traverseV2(TreeNode root, int depth) {
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
        traverseV2(root.left, depth + 1);
        traverseV2(root.right, depth + 1);
    }

    // ----------------------------------

    private List<List<Integer>> levelTraverseV3(TreeNode root) {
        if (root == null) {
            return res;
        }
        List<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        traverseV3(nodes);
        return res;
    }

    // 这个 traverseV3 函数很像递归遍历单链表的函数，其实就是把二叉树的每一层抽象理解成单链表的一个节点进行遍历。
    private void traverseV3(List<TreeNode> curLevelNodes) {
        // base case
        if (curLevelNodes.isEmpty()) {
            return;
        }
        // 前序位置，计算当前层的值和下一层的节点列表
        List<Integer> nodeValues = new LinkedList<>();
        List<TreeNode> nextLevelNodes = new LinkedList<>();
        for (TreeNode node : curLevelNodes) {
            nodeValues.add(node.val);
            if (node.left != null) {
                nextLevelNodes.add(node.left);
            }
            if (node.right != null) {
                nextLevelNodes.add(node.right);
            }
        }
        // 前序位置添加结果，可以得到自顶向下的层序遍历
        res.add(nodeValues);
        traverseV3(nextLevelNodes);
        // 后序位置添加结果，可以得到自底向上的层序遍历结果
        // res.add(nodeValues);
    }
}
