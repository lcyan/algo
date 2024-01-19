package cn.vvspace.algo.dp;

/**
 * <a href="">dp实现斐波那契数列</a>
 */
public class Solution027 {

    public static void main(String[] args) {
        Solution027 solution027 = new Solution027();
        System.out.println(solution027.fib(8));
    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
