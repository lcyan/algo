package cn.vvspace.algo.bt;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/n-queens-ii/description/">52. N 皇后 II</a>
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 * <p>
 * 输入：n = 4
 * 输出：2
 * <p>
 * 输入：n = 1
 * 输出：1
 */
public class Solution032 {

    private int res;

    public static void main(String[] args) {
        Solution032 solution032 = new Solution032();
        System.out.println(solution032.totalNQueens(4));
    }

    public int totalNQueens(int n) {
        // 初始化棋盘
        char[][] chessboard = new char[n][n];
        for (char[] chars : chessboard) {
            Arrays.fill(chars, '.');
        }
        backtrack(n, 0, chessboard);
        return res;
    }

    private void backtrack(int n, int row, char[][] chessboard) {

        if (n == row) {
            res++;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                backtrack(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, int n, char[][] chessboard) {
        //检查同列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45°
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135°
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
