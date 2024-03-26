package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/">106. 从中序与后序遍历序列构造二叉树</a>
 * <p>
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 */
public class Solution085 {

    private final Map<Integer, Integer> valueToIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valueToIndexMap.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int rootValue = postorder[postEnd];
        int index = valueToIndexMap.get(rootValue);
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootValue);

        root.left = buildTree(inorder, postorder, inStart, index - 1, postStart, postStart + leftSize - 1);
        root.right = buildTree(inorder, postorder, index + 1, inEnd, postStart + leftSize, postEnd - 1);

        return root;
    }
}
