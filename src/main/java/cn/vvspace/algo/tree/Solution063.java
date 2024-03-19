package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-paths/">257. 二叉树的所有路径</a>
 * <p>
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 输入：root = [1,2,3,null,5]
 * <p>
 * 输出：["1->2->5","1->3"]
 */
public class Solution063 {

    public List<String> binaryTreePaths(TreeNode root) {
        traverse(root);
        return res;
    }

    // 记录 traverse 函数递归时的路径
    LinkedList<String> path = new LinkedList<>();
    // 记录所有从根节点到叶子节点的路径
    LinkedList<String> res = new LinkedList<>();

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // root是叶子节点
        if (root.left == null && root.right == null) {
            path.addLast(root.val + "");
            res.add(String.join(" -> ", path));
            path.removeLast();
            return;
        }


        // 前序遍历位置
        path.addLast(root.val + "");
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        path.removeLast();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, //
                new TreeNode(2, //
                        null, //
                        new TreeNode(5)), //
                new TreeNode(3));

        System.out.println(new Solution063().binaryTreePaths(root));
    }

}
