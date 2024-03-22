package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/count-good-nodes-in-binary-tree/">1448. 统计二叉树中好节点的数目</a>
 * <p>
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 * <p>
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 * <p>
 * 输入：root = [3,1,4,3,null,1,5]
 * <p>
 * 输出：4
 * <p>
 * 解释：图中蓝色节点为好节点。
 * <p>
 * 根节点 (3) 永远是个好节点。
 * <p>
 * 节点 4 -> (3,4) 是路径中的最大值。
 * <p>
 * 节点 5 -> (3,4,5) 是路径中的最大值。
 * <p>
 * 节点 3 -> (3,1,3) 是路径中的最大值。
 */
public class Solution079 {

    private int cnt;

    public int goodNodes(TreeNode root) {
        traverse(root, root.val);
        return cnt;
    }

    private void traverse(TreeNode root, int pathMax) {
        if (root == null) {
            return;
        }

        if (pathMax <= root.val) {
            cnt++;
        }

        pathMax = Math.max(pathMax, root.val);
        traverse(root.left, pathMax);
        traverse(root.right, pathMax);
    }
}
