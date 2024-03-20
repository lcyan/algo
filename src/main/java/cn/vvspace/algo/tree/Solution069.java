package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/smallest-string-starting-from-leaf/description/">988. 从叶结点开始的最小字符串</a>
 * <p>
 * 给定一颗根结点为 root 的二叉树，树中的每一个结点都有一个 [0, 25] 范围内的值，分别代表字母 'a' 到 'z'。
 * <p>
 * 返回 按字典序最小 的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
 * <p>
 * 注：字符串中任何较短的前缀在 字典序上 都是 较小 的：
 * <p>
 * 例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。
 * <p>
 * 节点的叶节点是没有子节点的节点。
 */
public class Solution069 {

    private String res;
    private StringBuffer path = new StringBuffer();

    public String smallestFromLeaf(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            path.append((char) (root.val + 'a'));
            path.reverse();
            String s = path.toString();

            if (res == null || s.compareTo(res) < 0) {
                res = s;
            }

            path.reverse();
            path.deleteCharAt(path.length() - 1);
            return;
        }

        path.append((char) (root.val + 'a'));
        traverse(root.left);
        traverse(root.right);
        path.deleteCharAt(path.length() - 1);
    }
}
