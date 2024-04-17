package cn.vvspace.algo.repeat.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="">计算二叉树的节点数</a>
 */
public class Solution004 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.of(1, TreeNode.of(2, TreeNode.of(22), TreeNode.of(23)), TreeNode.of(3));
        System.out.println(new Solution004().count(root));

        for (int i = 0; i <= 4; i++) {
            System.out.printf("%d\t", new Solution004().fib(i));
        }
    }

    /**
     * // 定义：输入一棵二叉树，返回这棵二叉树的节点总数
     *
     * @param root root
     * @return cnt
     */
    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftCnt = count(root.left);
        int rightCnt = count(root.right);

        return leftCnt + rightCnt + 1;
    }

    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
