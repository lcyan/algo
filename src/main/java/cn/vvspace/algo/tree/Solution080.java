package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="">1469. 寻找所有的独生节点</a>
 * <p>
 * 二叉树中，如果一个节点是其父节点的唯一子节点，则称这样的节点为独生节点。二叉树的根节点不会是独生节点，因为它没有父节点。
 * <p>
 * 给定一棵二叉树的根节点 root，返回树中所有的独生节点的值所构成的数组。数组的顺序 不限。
 */
public class Solution080 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> getLonelyNodes(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null && root.right == null) {
            res.add(root.left.val);
        }

        if (root.right != null && root.left == null) {
            res.add(root.right.val);
        }
        traverse(root.left);
        traverse(root.right);

    }
}
