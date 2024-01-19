package cn.vvspace.algo.tree;

import java.util.stream.IntStream;

/**
 * <a href="">斐波那契数列</a>
 */
public class SolutionFib {


    public static void main(String[] args) {
        SolutionFib solutionFib = new SolutionFib();
        IntStream.range(0, 10).forEach(n -> System.out.printf("%d ", solutionFib.fib(n)));
    }

    // 1、1、2、3、5、8、13、21
    private int fib(int n) {
        int[] memo = new int[n + 1];
        return dp(memo, n);
    }

    private int dp(int[] memo, int n) {
        if (n <= 1) {
            return n;
        }

        if (memo[n] != 0) {
            return memo[n];
        } else {
            memo[n] = fib(n - 1) + fib(n - 2);
            return fib(n - 1) + fib(n - 2);
        }
    }
}
