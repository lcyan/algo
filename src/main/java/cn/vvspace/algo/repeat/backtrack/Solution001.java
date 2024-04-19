package cn.vvspace.algo.repeat.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="">N皇后问题</a>
 */
public class Solution001 {
    List<List<String>> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new Solution001().solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] row : chessboard) {
            Arrays.fill(row, '.');
        }
        backtrack(chessboard, 0, n);
        return res;
    }

    // 路径：board 中小于 row 的那些行都已经成功放置了皇后
    // 选择列表：第 row 行的所有列都是放置皇后的选择
    // 结束条件：row 超过 board 的最后一行
    private void backtrack(char[][] chessboard, int row, int n) {
        if (row == n) {
            res.add(arrayToList(chessboard));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(chessboard, row, col, n)) {
                continue;
            }
            chessboard[row][col] = 'Q';
            backtrack(chessboard, row + 1, n);
            chessboard[row][col] = '.';
        }
    }

    private List<String> arrayToList(char[][] chessboard) {
        List<String> res = new ArrayList<>();
        for (char[] chars : chessboard) {
            res.add(new String(chars));
        }
        return res;
    }

    private boolean isValid(char[][] chessboard, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
