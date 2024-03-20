package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/sum-root-to-leaf-numbers/description/">129. 求根节点到叶节点数字之和</a>
 * <p>
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 * <p>
 * 输入：root = [1,2,3]
 * <p>
 * 输出：25
 * <p>
 * 解释：
 * <p>
 * 从根到叶子节点路径 1->2 代表数字 12
 * <p>
 * 从根到叶子节点路径 1->3 代表数字 13
 * <p>
 * 因此，数字总和 = 12 + 13 = 25
 */
public class Solution064 {

    int res;
    StringBuffer path = new StringBuffer();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, //
                new TreeNode(2, //
                        null, //
                        new TreeNode(5)), //
                new TreeNode(3));

        System.out.println(new Solution064().sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        path.append(root.val);
        if (root.left == null && root.right == null) {
            res += Integer.parseInt(path.toString());
        }

        traverse(root.left);
        traverse(root.right);
        path.deleteCharAt(path.length() - 1);
    }
}
