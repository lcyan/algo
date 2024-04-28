package cn.vvspace.algo.repeat.bst;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/open-the-lock/description/">752. 打开转盘锁</a>
 */
public class Solution002 {

    private Set<String> deadendSet = new HashSet<>();
    private Set<String> visited = new HashSet<>();
    private String target;


    public int openLock(String[] deadends, String target) {
        deadendSet.addAll(Arrays.asList(deadends));
        this.target = target;
        return bfs("0000");
    }


    private String plusOne(String s, int i) {
        char[] charArray = s.toCharArray();

        if (charArray[i] == '9') {
            charArray[i] = '0';
        } else {
            charArray[i] += 1;
        }

        return new String(charArray);
    }


    private String minusOne(String s, int i) {
        char[] charArray = s.toCharArray();

        if (charArray[i] == '0') {
            charArray[i] = '9';
        } else {
            charArray[i] -= 1;
        }

        return new String(charArray);
    }

    private int bfs(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(s);
        visited.add(s);
        int step = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();

                if (target.equals(cur)) {
                    return step;
                }

                if (deadendSet.contains(cur)) {
                    continue;
                }

                for (int j = 0; j < Objects.requireNonNull(cur).length(); j++) {
                    String plusOne = plusOne(cur, j);
                    if (!visited.contains(plusOne)) {
                        q.offer(plusOne);
                        visited.add(plusOne);
                    }

                    String minusOne = minusOne(cur, j);
                    if (!visited.contains(minusOne)) {
                        q.offer(minusOne);
                        visited.add(minusOne);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
