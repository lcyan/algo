package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.stream.IntStream;

/**
 * <a href="">给你一棵二叉树，请你用遍历的思路写一个 traverse 函数，打印出遍历这棵二叉树的过程</a>
 */
public class Solution024 {
    public int depth = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, //
                new TreeNode(2), //
                new TreeNode(3)); //

        Solution024 solution024 = new Solution024();
        solution024.traverse(root);
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        depth++;
        System.out.printf("%s从节点 %s 进入左节点 %s%n", format(depth), root, root.left);
        traverse(root.left);
        System.out.printf("%s从左节点 %s 回到节点 %s%n", format(depth), root.left, root);

        System.out.printf("%s从节点 %s 进入右节点 %s%n", format(depth), root, root.right);
        traverse(root.right);
        System.out.printf("%s从右节点 %s 回到节点 %s%n", format(depth), root.right, root);
        depth--;
    }

    private String format(int depth) {
        StringBuffer sb = new StringBuffer();
        IntStream.range(0, depth).forEach(i -> sb.append("\t"));
        return sb.toString();
    }
}
