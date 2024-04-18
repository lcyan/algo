package cn.vvspace.algo.repeat.tree;

import java.util.Arrays;

/**
 * <a href="">零钱兑换</a>
 */
public class Solution007 {


    // 带备忘录版本
    int[] memo;

    // coins 中是可选硬币面值，amount 是目标金额
    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }

    public int coinChangeV2(int[] coins, int amount) {
        memo = new int[]{amount + 1};
        Arrays.fill(memo, -2);
        return dpV2(coins, amount);
    }

    // 定义：要凑出金额 n，至少要 dp(coins, n) 个硬币
    private int dp(int[] coins, int amount) {
        // base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = coinChange(coins, amount - coin);
            // 子问题误解，直接跳过
            if (subProblem == -1) {
                continue;
            }

            // 在子问题中选择最优解，然后加一
            res = Math.min(res, 1 + subProblem);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dpV2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        if (memo[amount] != -2) {
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dpV2(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }

            res = Math.min(res, subProblem + 1);
        }
        // 把计算结果存入备忘录
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }
}
