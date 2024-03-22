package cn.vvspace.algo.base;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {this.val = val;}

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode of(int val) {
        return of(val, null, null);
    }

    public static TreeNode of(int val, TreeNode left, TreeNode right) {
        TreeNode node = new TreeNode();
        node.val = val;
        node.left = left;
        node.right = right;
        return node;
    }

    @Override
    public String toString() {
        return "TreeNode{" + "val=" + val + '}';
    }
}
