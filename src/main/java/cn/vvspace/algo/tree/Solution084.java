package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://labuladong.online/algo/tree-class/100-dao-xi-083dc/qiang-hua--7f815/">105. 从前序与中序遍历序列构造二叉树</a>
 * <p>
 * 给定一棵树的前序遍历结果 preorder 与中序遍历结果 inorder，请构造二叉树并返回其根节点。
 */
public class Solution084 {

    private final Map<Integer, Integer> valueToIndexMap = new HashMap<>();

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        new Solution084().buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valueToIndexMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {

        if (preStart > preEnd) {
            return null;
        }

        int rootValue = preorder[preStart];
        int index = valueToIndexMap.get(rootValue);
        int leftSize = index - inStart;

        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(preorder, inorder, preStart + 1, preStart + leftSize, inStart, index - 1);
        root.right = buildTree(preorder, inorder, preStart + leftSize + 1, preEnd, index + 1, inEnd);

        return root;
    }
}
