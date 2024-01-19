package cn.vvspace.algo.dp;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/coin-change/description/">322. 零钱兑换</a>
 * <p>
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 */
public class Solution028 {

    private int[] memo;

    public static void main(String[] args) {
        Solution028 solution028 = new Solution028();
        System.out.println(solution028.coinChange(new int[]{1, 2, 5}, 11));
    }

    /**
     * 1、确定 base case，这个很简单，显然目标金额 amount 为 0 时算法返回 0，因为不需要任何硬币就已经凑出目标金额了。
     * <p>
     * 2、确定「状态」，也就是原问题和子问题中会变化的变量。由于硬币数量无限，硬币的面额也是题目给定的，只有目标金额会不断地向 base case 靠近，所以唯一的「状态」就是目标金额 amount。
     * <p>
     * 3、确定「选择」，也就是导致「状态」产生变化的行为。目标金额为什么变化呢，因为你在选择硬币，你每选择一枚硬币，就相当于减少了目标金额。所以说所有硬币的面值，就是你的「选择」。
     * <p>
     * 4、明确 dp 函数/数组的定义。我们这里讲的是自顶向下的解法，所以会有一个递归的 dp 函数，一般来说函数的参数就是状态转移中会变化的量，也就是上面说到的「状态」；函数的返回值就是题目要求我们计算的量。就本题来说，状态只有一个，即「目标金额」，题目要求我们计算凑出目标金额所需的最少硬币数量。
     * <p>
     * 所以我们可以这样定义 dp 函数：dp(n) 表示，输入一个目标金额 n，返回凑出目标金额 n 所需的最少硬币数量。
     *
     * @param coins  表示不同面额的硬币
     * @param amount 总金额
     * @return 可以凑成总金额所需的 最少的硬币个数
     */
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MIN_VALUE);
        return dpV3(coins, amount);
    }

    // 迭代解法
    private int dpV3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int initVal = amount + 1; // 不能定义为Integer.MAX_VALUE 下面的代码1 + dp[i - coin]会越界
        Arrays.fill(dp, initVal);
        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == initVal) ? -1 : dp[amount];

    }

    // 定义：要凑出金额 n，至少要 dp(coins, n) 个硬币
    private int dpV2(int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;


        // 查备忘录，防止重复计算
        if (memo[amount] != Integer.MIN_VALUE) {
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        // 做选择，选择需要硬币最少的那个结果
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dpV2(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }

        // 把计算结果存入备忘录
        memo[amount] = (res == Integer.MAX_VALUE ? -1 : res);
        return memo[amount];
    }


    private int dp(int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int res = Integer.MAX_VALUE;
        // 做选择，选择需要硬币最少的那个结果
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
