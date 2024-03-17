package cn.vvspace.algo.tree;

/**
 * <a href="">1650 题「二叉树的最近公共祖先 III」</a>
 * <p>
 * 这次输入的二叉树节点比较特殊，包含指向父节点的指针：
 */
public class Solution055 {


    static class Node {
        int val;
        Node left;
        Node right;
        Node parent;
    }

    ;

    Node lowestCommonAncestor(Node p, Node q) {
        Node a = p, b = q;
        while (a != b) {
            if (a == null) {
                a = q;
            } else {
                a = a.parent;
            }

            if (b == null) {
                b = p;
            } else {
                b = b.parent;
            }
        }

        return a;
    }

}
