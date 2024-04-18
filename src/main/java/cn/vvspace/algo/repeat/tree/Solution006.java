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

    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int fib3(int n) {
        if (n == 0) {
            return 0;
        }

        int i_1 = 1;
        int i_2 = 0;
        for (int i = 2; i <= n; i++) {
            int dp_i = i_1 + i_2;
            i_2 = i_1;
            i_1 = dp_i;
        }
        return i_1;
    }

}
