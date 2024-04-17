package cn.vvspace.algo.repeat.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="">打印tree每一层的数据</a>
 */
public class Solution002 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.of(1, TreeNode.of(2, TreeNode.of(22), null), TreeNode.of(3));
        new Solution002().count(root);
    }

    public void traverse(TreeNode root) {
        traverse(root, 1);
    }

    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftCnt = count(root.left);
        int rightCnt = count(root.right);
        System.out.printf("节点 %s 的左子树有 %d 个节点，右子树有 %d 个节点\r\n", root, leftCnt, rightCnt);
        return leftCnt + rightCnt + 1;
    }

    private void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        System.out.printf("节点 %s 在第 %d 层\r\n", root, level);
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }
}
