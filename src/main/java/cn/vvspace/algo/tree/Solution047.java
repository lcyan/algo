package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/">106. 从中序与后序遍历序列构造二叉树</a>
 * <p>
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 */
public class Solution047 {

    private final Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        new Solution047().buildTree(inorder, postorder);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    // 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
    // 输出：[3,9,20,null,null,15,7]
    private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        int rootIndex = inorderIndexMap.get(rootVal);

        int leftLen = rootIndex - inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + leftLen - 1);
        root.right = buildTree(inorder, postorder, rootIndex + 1, inEnd, postStart + leftLen , postEnd - 1);

        return root;
    }
}
