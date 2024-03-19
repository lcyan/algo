package cn.vvspace.algo.tree.bst;

/**
 * <a href="https://leetcode.cn/problems/unique-binary-search-trees/description/">96. 不同的二叉搜索树</a>
 * <p>
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 19
 */
public class Solution061 {
    int[][] memo;

    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    // 定义：闭区间 [lo, hi] 的数字能组成 count(lo, hi) 种 BST
    int count(int lo, int hi) {

        // 注意 base case，显然当 lo > hi 闭区间 [lo, hi] 肯定是个空区间，
        // 也就对应着空节点 null，虽然是空节点，但是也是一种情况，所以要返回 1 而不能返回 0
        if (lo > hi) {
            return 1;
        }

        int res = 0;
        for (int i = lo; i <= hi; i++) {
            // i的值作为根节点
            int left = count(lo, i - 1);
            int right = count(i + 1, hi);
            res += left * right;
        }
        return res;
    }


    // 增加备忘录，降低时间复杂度
    int countV1(int lo, int hi) {
        if (lo > hi) {
            return 1;
        }

        int res = 0;
        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }
        for (int i = lo; i <= hi; i++) {
            int left = countV1(lo, i - 1);
            int right = countV1(i + 1, hi);
            res += left * right;
        }
        memo[lo][hi] = res;
        return res;
    }
}
