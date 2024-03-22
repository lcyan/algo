package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/vertical-order-traversal-of-a-binarcol-tree/description/">987. 二叉树的垂序遍历</a>
 * <p>
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 * <p>
 * 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 * <p>
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * <p>
 * 返回二叉树的 垂序遍历 序列。
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * <p>
 * 输出：[[9],[3,15],[20],[7]]
 * <p>
 * 解释：
 * <p>
 * 列 -1 ：只有结点 9 在此列中。
 * <p>
 * 列  0 ：只有结点 3 和 15 在此列中，按从上到下顺序。
 * <p>
 * 列  1 ：只有结点 20 在此列中。
 * <p>
 * 列  2 ：只有结点 7 在此列中。
 */

public class Solution076 {

    private final List<FatTreeNode> nodes = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();

        traverse(root, 0, 0);
        nodes.sort((node1, node2) -> {
            if (node1.row == node2.row && node1.col == node2.col) {
                return Integer.compare(node1.treeNode.val, node2.treeNode.val);
            }

            if (node1.col == node2.col) {
                return Integer.compare(node1.row, node2.row);
            }
            return Integer.compare(node1.col, node2.col);
        });

        int preCol = Integer.MIN_VALUE;
        for (FatTreeNode cur : nodes) {
            if (cur.col != preCol) {
                res.addLast(new LinkedList<>());
                preCol = cur.col;
            }
            res.getLast().add(cur.treeNode.val);
        }

        return res;
    }

    private void traverse(TreeNode root, int row, int col) {
        if (root == null) {
            return;
        }

        nodes.add(new FatTreeNode(root, row, col));
        traverse(root.left, row + 1, col - 1);
        traverse(root.right, row + 1, col + 1);
    }

    static class FatTreeNode {
        private final TreeNode treeNode;
        private final int row;
        private final int col;

        public FatTreeNode(TreeNode treeNode, int row, int col) {
            this.treeNode = treeNode;
            this.row = row;
            this.col = col;
        }

    }

}
