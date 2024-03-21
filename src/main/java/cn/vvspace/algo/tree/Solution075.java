package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/flip-binary-tree-to-match-preorder-traversal/description/">971. 翻转二叉树以匹配先序遍历</a>
 * <p>
 * 给你一棵二叉树的根节点 root ，树中有 n 个节点，每个节点都有一个不同于其他节点且处于 1 到 n 之间的值。
 * <p>
 * 另给你一个由 n 个值组成的行程序列 voyage ，表示 预期 的二叉树 先序遍历 结果。
 * <p>
 * 通过交换节点的左右子树，可以 翻转 该二叉树中的任意节点。例，翻转节点 1 的效果如下：
 * <p>
 * 请翻转 最少 的树中节点，使二叉树的 先序遍历 与预期的遍历行程 voyage 相匹配 。
 * <p>
 * 如果可以，则返回 翻转的 所有节点的值的列表。你可以按任何顺序返回答案。如果不能，则返回列表 [-1]。
 * <p>
 * 输入：root = [1,2,3], voyage = [1,3,2]
 * <p>
 * 输出：[1]
 * <p>
 * 解释：交换节点 2 和 3 来翻转节点 1 ，先序遍历可以匹配预期行程。
 * <p>
 * 提示：
 * <p>
 * 树中的节点数目为 n
 * <p>
 * n == voyage.length
 * <p>
 * 1 <= n <= 100
 * <p>
 * 1 <= Node.val, voyage[i] <= n
 * <p>
 * 树中的所有值 互不相同
 * <p>
 * voyage 中的所有值 互不相同
 */
public class Solution075 {

    List<Integer> res = new LinkedList<>();
    int i = 0;
    int[] voyage;
    boolean canFlip = true;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;
        traverse(root);
        if (canFlip) {
            return res;
        }
        return Collections.singletonList(-1);
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.val != voyage[i++]) {
            canFlip = false;
            return;
        }

        if (root.left != null && root.left.val != voyage[i]) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            res.add(root.val);
        }

        traverse(root.left);
        traverse(root.right);
    }
}
