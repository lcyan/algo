package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.Node;

/**
 * <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/description/">116. 填充每个节点的下一个右侧节点指针</a>
 * <p>
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */
public class Solution043 {

    public static void main(String[] args) {
    }

    public Node connect(Node root) {

        connect(root.left, root.right);
        return root;
    }

    private void connect(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }

        node1.next = node2;
        connect(node1.left, node1.right);
        connect(node2.left, node2.right);
        connect(node1.right, node2.left);
    }


    public void traverse(Node root) {
        if (root == null || root.left == null) {
            return;
        }

        root.left.next = root.right;
        traverse(root.left);
        traverse(root.right);
    }
}
