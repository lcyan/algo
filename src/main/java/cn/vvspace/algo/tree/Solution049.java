package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/find-duplicate-subtrees/">652. 寻找重复的子树</a>
 * <p>
 * 给你一棵二叉树的根节点 root ，返回所有 重复的子树 。
 * <p>
 * 对于同一类的重复子树，你只需要返回其中任意 一棵 的根结点即可。
 * <p>
 * 如果两棵树具有 相同的结构 和 相同的结点值 ，则认为二者是 重复 的。
 */
public class Solution049 {

    // 记录所有子树以及出现的次数
    HashMap<String, Integer> subtrees = new HashMap<>();
    // 记录重复子树的根节点
    List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return res;
    }

    private String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = serialize(root.left);
        String right = serialize(root.right);

        String myself = left + "," + right + "," + root.val;
        int count = subtrees.getOrDefault(myself, 0);

        if (count == 1) {
            res.add(root);
        }

        subtrees.put(myself, count + 1);

        return myself;
    }
}
