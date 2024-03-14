package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/">105. 从前序与中序遍历序列构造二叉树</a>
 * <p>
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class Solution046 {

    public static void main(String[] args) {
    }

    // 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    // 输出: [3,9,20,null,null,15,7]
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inorder[i]) {
                index = i;
                break;
            }
        }

        int leftLen = index - inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, inorder, preStart + 1, preStart + leftLen, inStart, index - 1);
        root.right = buildTree(preorder, inorder, preStart + leftLen + 1, preEnd, index + 1, inEnd);

        return root;
    }
}
