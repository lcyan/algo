package cn.vvspace.algo.tree;

import cn.vvspace.algo.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/">297. 二叉树的序列化与反序列化</a>
 * <p>
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 */
public class Solution050 {

    public static final String SEP = ",";
    public static final String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        LinkedList<String> nodes = new LinkedList<>();
        for (String node : data.split(SEP)) {
            nodes.addLast(node);
        }
        return deserialize(nodes);
    }

    /** 使用后序方式实现序列与反序列化 **/
    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        sb.append(root.val).append(SEP);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    private TreeNode deserialize(Deque<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }

        String first = nodes.removeFirst();
        if (NULL.equals(first)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }


    /** 使用后序方式实现序列与反序列化 **/
    private void serializeV1(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        serializeV1(root.left, sb);
        serializeV1(root.right, sb);
        // 后序位置
        sb.append(root.val).append(SEP);
    }

    private TreeNode deserializeV1(Deque<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        // 从后往前取出元素
        String last = nodes.removeLast();
        if (NULL.equals(last)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(last));
        // 先构造右子树, 再构造左子树
        root.right = deserializeV1(nodes);
        root.left = deserializeV1(nodes);
        return root;
    }

    /** 使用层级遍历方式实现序列与反序列化 **/
    private String serializeV2(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode node = q.pop();
                if (node == null) {
                    sb.append(NULL).append(SEP);
                    continue;
                }
                sb.append(node.val).append(SEP);
                q.offer(node.left);
                q.offer(node.right);
            }
        }

        return sb.toString();
    }

    private TreeNode deserializeV2(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] nodes = data.split(SEP);
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int index = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode parent = q.pop();
                String left = nodes[index++];

                if (!NULL.equals(left)) {
                    parent.left = new TreeNode(Integer.parseInt(left));
                    q.offer(parent.left);
                }

                String right = nodes[index++];
                if (!NULL.equals(right)) {
                    parent.right = new TreeNode(Integer.parseInt(right));
                    q.offer(parent.right);
                }
            }
        }

        return root;
    }
}
