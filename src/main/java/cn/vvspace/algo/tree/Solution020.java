package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="">打印树节点所在层次</a>
 * <p>
 * 1、如果把根节点看做第 1 层，如何打印出每一个节点所在的层数？
 * <p>
 * 2、如何打印出每个节点的左右子树各有多少节点？
 * <p>
 * 这两个问题的根本区别在于：一个节点在第几层，你从根节点遍历过来的过程就能顺带记录，用递归函数的参数就能传递下去；
 * 而以一个节点为根的整棵子树有多少个节点，你需要遍历完子树之后才能数清楚，然后通过递归函数的返回值拿到答案。
 */
public class Solution020 {

    private static int depth = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, //
                new TreeNode(2, //
                        new TreeNode(5), //
                        new TreeNode(4, //
                                new TreeNode(6), new TreeNode(7))), //
                new TreeNode(3, //
                        new TreeNode(8), new TreeNode(9)));
        //traverse(root);
        traverseV2(root);
    }


    private static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        System.out.printf("节点 %s, 层数 %d%n", root.val, depth);
        traverse(root.left);
        traverse(root.right);
        depth--;
    }

    private static int traverseV2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = traverseV2(root.left);
        int rightCount = traverseV2(root.right);
        System.out.printf("节点 %s, 左子树节点数 %d, 右子树节点数 %d%n", root.val, leftCount - 1, rightCount - 1);
        return leftCount + rightCount + 1;
    }
}
