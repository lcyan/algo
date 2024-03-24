package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/path-sum-iii/description/">437. 路径总和 III</a>
 * <p>
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * <p>
 * 输出：3
 * <p>
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * <p>
 * 输出：3
 */
public class Solution082 {

    // 定义：从二叉树的根节点开始，路径和为 pathSum 的路径有 preSumCount.get(pathSum) 个
    private HashMap<Integer, Integer> preSumCount = new HashMap<>();
    private int res;
    private int targetSum;
    private int pathSum;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10, //
                TreeNode.of(5, //
                        TreeNode.of(3,//
                                TreeNode.of(3), //
                                TreeNode.of(-2)), //
                        TreeNode.of(2, //
                                null, //
                                TreeNode.of(1))), //
                TreeNode.of(-3, null, TreeNode.of(11)));
        System.out.println(new Solution082().pathSum(root, 8));
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        this.pathSum = 0;
        this.targetSum = targetSum;
        this.preSumCount.put(0, 1);
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 前序遍历位置
        pathSum += root.val;
        // 从二叉树的根节点开始，路径和为 pathSum - targetSum 的路径条数
        // 就是路径和为 targetSum 的路径条数
        // 两节点间的路径和 = 两节点的前缀和之差
        res += preSumCount.getOrDefault(pathSum - targetSum, 0);
        // 记录从二叉树的根节点开始，路径和为 pathSum 的路径条数
        preSumCount.put(pathSum, preSumCount.getOrDefault(pathSum, 0) + 1);

        traverse(root.left);
        traverse(root.right);

        // 后序遍历位置
        preSumCount.put(pathSum, preSumCount.get(pathSum) - 1);
        pathSum -= root.val;
    }
}
