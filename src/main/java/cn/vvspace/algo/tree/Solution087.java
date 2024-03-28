package cn.vvspace.algo.tree;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/description/">331. 验证二叉树的前序序列化</a>
 * <p>
 * 序列化二叉树的一种方法是使用 前序遍历 。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 * <p>
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 * <p>
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 * <p>
 * 保证 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 * <p>
 * 你可以认为输入格式总是有效的
 * <p>
 * 例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 * 注意：不允许重建树。
 */
public class Solution087 {

    // 一种更巧妙的解法，就是利用二叉树节点和边的关系。
    // 每个非空的二叉树节点都会产生两条边，并消耗一条边；而每个空节点只会消耗一条边：
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");

        int edge = 1;
        for (String node : nodes) {
            if ("#".equals(node)) {
                edge -= 1;
                if (edge < 0) {
                    return false;
                }
            } else {
                edge -= 1;
                if (edge < 0) {
                    return false;
                }
                edge += 2;
            }
        }
        return edge == 0;
    }

    public boolean isValidSerializationV1(String preorder) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String node : preorder.split(",")) {
            nodes.addLast(node);
        }

        return deserialize(nodes) && nodes.isEmpty();
    }

    private boolean deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return false;
        }

        String node = nodes.removeFirst();
        if ("#".equals(node)) {
            return true;
        }
        return deserialize(nodes) && deserialize(nodes);
    }
}
