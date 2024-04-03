package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href=""></a>
 * <p>
 * 1430. 判断给定的序列是否是二叉树从根到叶的路径
 */
public class Solution096 {

    public boolean isValidSequence(TreeNode root, int[] arr) {
        return check(root, arr, 0);
    }

    private boolean check(TreeNode root, int[] arr, int i) {
        if (root == null || i == arr.length) {
            return false;
        }

        if (root.left == null && root.right == null) {
            if (root.val == arr[i] && i == arr.length - 1) {
                return true;
            }
        }

        if (root.val != arr[i]) {
            return false;
        }

        return check(root.left, arr, i + 1) || check(root.right, arr, i + 1);
    }
}
