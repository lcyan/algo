package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="">前序遍历</a>
 * <p/>
 * <img src="https://pic5.58cdn.com.cn/nowater/webim/big/n_v2fc73f6be2ae242279a2a0e9d6fb4a187.png"/>
 */
public class Solution019 {

    public static final List<Integer> preorderRes = new ArrayList<>();
    public static final List<Integer> inorderRes = new ArrayList<>();
    public static final List<Integer> postorderRes = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, //
                new TreeNode(2, //
                        new TreeNode(5), //
                        new TreeNode(4, //
                                new TreeNode(6), new TreeNode(7))), //
                new TreeNode(3, //
                        new TreeNode(8), new TreeNode(9)));
        traverse(root);
        System.out.println("pre -> " + preorderRes);
        System.out.println("pre -> " + preorderTraverse(root));
        System.out.println("mid -> " + inorderRes);
        System.out.println("post -> " + postorderRes);
    }

    public static void traverse(TreeNode root) {

        if (root == null) {
            return;
        }

        preorderRes.add(root.val);
        traverse(root.left);
        //inorderRes.add(root.val);
        traverse(root.right);
        //postorderRes.add(root.val);
    }

    public static List<Integer> preorderTraverse(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        // 前序遍历的结果，root.val 在第一个
        res.add(root.val);
        // 利用函数定义，后面接着左子树的前序遍历结果
        res.addAll(preorderTraverse(root.left));
        // 利用函数定义，最后接着右子树的前序遍历结果
        res.addAll(preorderTraverse(root.right));

        return res;
    }
}
