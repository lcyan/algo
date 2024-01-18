package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="">计算一颗二叉树一共有多少个节点</a>
 */
public class Solution023 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, //
                new TreeNode(2, //
                        new TreeNode(5), //
                        new TreeNode(4, //
                                new TreeNode(6), new TreeNode(7))), //
                new TreeNode(3, //
                        new TreeNode(8), new TreeNode(9)));

        Solution023 solution023 = new Solution023();
        System.out.printf("nodeCnt -> %d%n", solution023.traverse(root));
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 我这个节点关心的是我的两个子树的节点总数分别是多少
        int leftCnt = traverse(root.left);
        int rightCnt = traverse(root.right);
        // 后序位置，左右子树节点数加上自己就是整棵树的节点数
        return 1 + leftCnt + rightCnt;
    }

}
