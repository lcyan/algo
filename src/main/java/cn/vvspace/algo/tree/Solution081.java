package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="">1602. 找到二叉树中最近的右侧节点</a>
 * <p>
 * 给定一棵二叉树的根节点 root 和树中的一个节点 u，返回与 u 所在层中距离最近的右侧节点，当 u 是所在层中最右侧的节点，返回 null。
 * <p>
 * 输入：root = [1,2,3,null,4,5,6], u = 4
 * <p>
 * 输出：5
 * <p>
 * 解释：节点 4 所在层中，最近的右侧节点是节点 5。
 */
public class Solution081 {

    private TreeNode res;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, TreeNode.of(2, null, TreeNode.of(4)),
                TreeNode.of(3, TreeNode.of(5), TreeNode.of(6)));
        System.out.println(new Solution081().findNearestRightNode(root, TreeNode.of(4)));
    }

    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        traverse(root, u);
        return res;
    }

    private void traverse(TreeNode root, TreeNode u) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.pop();

                if (cur.val == u.val) {
                    if (i + 1 < sz) {
                        res = q.pop();
                    }
                    return;
                }

                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
    }
}
