package cn.vvspace.algo.tree.lab;

import cn.vvspace.algo.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树遍历框架
 */
public class TreeTraverse {

    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = //
                new TreeNode(3, //
                        new TreeNode(9), //
                        new TreeNode(20, //
                                new TreeNode(15), //
                                new TreeNode(7)));
        System.out.println(new TreeTraverse().minDepth(root));
    }

    public int minDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int depth = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                assert cur != null;
                if (cur.left == null && cur.right == null) {
                    return depth;
                }

                if (cur.left != null) {
                    q.offer(cur.left);
                }

                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            depth++;
        }

        return depth;
    }

    void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        System.out.println("level: " + level);
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }

    int count(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + 1;
    }

}
