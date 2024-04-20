package cn.vvspace.algo.repeat.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="">大小为K的组合</a>
 */
public class Solution003 {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int k;

    public static void main(String[] args) {
        System.out.println(new Solution003().combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        backtrack(n, 1);
        return res;
    }

    private void backtrack(int n, int start) {
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, i + 1);
            track.removeLast();
        }
    }
}
