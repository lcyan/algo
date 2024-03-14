package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/maximum-binary-tree/">654. 最大二叉树</a>
 * <p>
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 *
 * <li>创建一个根节点，其值为 nums 中的最大值。</li>
 * <li>递归地在最大值 左边 的 子数组前缀上 构建左子树。</li>
 * <li>递归地在最大值 右边 的 子数组后缀上 构建右子树。</li>
 * <p>
 * 返回 nums 构建的 最大二叉树 。
 */
public class Solution045 {

    public static void main(String[] args) {

        TreeNode treeNode = new Solution045().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (null == nums) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }

        int maxVal = nums[low];
        int index = low;

        for (int i = low + 1; i <= high; i++) {
            if (nums[index] < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }

        TreeNode root = new TreeNode(maxVal);
        root.left = buildTree(nums, low, index - 1);
        root.right = buildTree(nums, index + 1, high);

        return root;
    }
}
