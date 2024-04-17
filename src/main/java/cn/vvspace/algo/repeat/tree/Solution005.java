package cn.vvspace.algo.repeat.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="">使用递归方式实现层序遍历</a>
 */
public class Solution005 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelTraverse(TreeNode root) {
        if (root == null) {
            return res;
        }
        traverse(root, 0);
        return res;
    }

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
}
