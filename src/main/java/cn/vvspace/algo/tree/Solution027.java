package cn.vvspace.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/number-of-islands/">200. 岛屿数量</a>
 * <p>
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class Solution027 {


    private int count;

    public static void main(String[] args) {
        char[][] grid = new char[][]{ //
                {'1', '1', '1', '1', '0'}, //
                {'1', '1', '0', '1', '0'}, //
                {'1', '1', '0', '0', '0'}, //
                {'0', '0', '0', '1', '0'}};

        System.out.println(new Solution027().numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        grid[i][j] = '0';
        q.offer(new int[]{i, j});

        while (!q.isEmpty()) {
            int sz = q.size();

            for (int k = 0; k < sz; k++) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];

                // 上
                if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                    q.offer(new int[]{x, y - 1});
                    grid[x][y - 1] = '0';
                }

                // 下
                if (y + 1 < n && grid[x][y + 1] == '1') {
                    q.offer(new int[]{x, y + 1});
                    grid[x][y + 1] = '0';
                }

                // 左
                if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                    q.offer(new int[]{x - 1, y});
                    grid[x - 1][y] = '0';
                }

                // 右
                if (x + 1 < m && grid[x + 1][y] == '1') {
                    q.offer(new int[]{x + 1, y});
                    grid[x + 1][y] = '0';
                }
            }
        }
    }
}
