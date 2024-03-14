package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/">889. 根据前序和后序遍历构造二叉树</a>
 * <p>
 * 给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
 * <p>
 * 如果存在多个答案，您可以返回其中 任何 一个。
 */
public class Solution048 {

    private final Map<Integer, Integer> valToIndexMap = new HashMap<>();

    // 输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
    // 输出：[1,2,3,4,5,6,7]
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            valToIndexMap.put(postorder[i], i);
        }
        return buildTree(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, int postEnd) {

        if (preStart > preEnd) {
            return null;
        }

        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int rootVal = preorder[preStart];
        int leftRootVal = preorder[preStart + 1];

        int index = valToIndexMap.get(leftRootVal);
        int leftLen = index - postStart + 1;

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, postorder, preStart + 1, preStart + leftLen, postStart, index);
        root.right = buildTree(preorder, postorder, preStart + 1 + leftLen, preEnd, index + 1, postEnd - 1);

        return root;
    }

}
