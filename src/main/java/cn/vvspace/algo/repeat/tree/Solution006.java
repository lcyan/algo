package cn.vvspace.algo.repeat.tree;

/**
 * <a href="https://leetcode.cn/problems/fibonacci-number/">509. 斐波那契数</a>
 */
public class Solution006 {


    public int fib(int n) {
        int[] memo = new int[n + 1];
        return dp(memo, n);

    }

    private int dp(int[] memo, int n) {
        if (n < 2) {
            return n;
        }

        if (memo[n] == 0) {
            memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
        }
        return memo[n];
    }

}
