package cn.vvspace.algo.repeat.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/n-queens/">51. N 皇后</a>
 */
public class Solution009 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        String[][] chessboards = new String[n][n];
        for (String[] chessboard : chessboards) {
            Arrays.fill(chessboard, ".");
        }
        LinkedList<String> track = new LinkedList<>();
        backtrack(chessboards, 0);
        return res;
    }

    // 决策树的每一层表示棋盘上的每一行；
    // 每个节点可以做出的选择是，在该行的任意一列放置一个皇后。
    private void backtrack(String[][] chessboards, int row) {
        if (row == chessboards.length) {
            for (String[] chessboard : chessboards) {
                res.add(Arrays.asList(chessboard));
            }
            return;
        }

        int n = chessboards[row].length;
        for (int col = 0; col < n; col++) {

            // 排除不合法选择
            if (!isValid(chessboards, row, col)) {

                continue;
            }

            chessboards[row][col] = "Q";
            backtrack(chessboards, row + 1);
            chessboards[row][col] = ".";
        }
    }

    private boolean isValid(String[][] chessboards, int row, int col) {

        for (int i = 0; i <= row; i++) {
            if ("Q".equals(chessboards[i][col])) {
                return false;
            }
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < chessboards.length; i--, j++) {
            if ("Q".equals(chessboards[i][j])) return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if ("Q".equals(chessboards[i][j])) return false;
        }
        return true;
    }
}
