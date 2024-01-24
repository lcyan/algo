package cn.vvspace.algo.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/open-the-lock/description/">752. 打开转盘锁</a>
 * <p>
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * <p>
 * 示例 1:
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * <p>
 * 输出：6
 * <p>
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * <p>
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * <p>
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * <p>
 * 示例 2:
 * <p>
 * 输入: deadends = ["8888"], target = "0009"
 * <p>
 * 输出：1
 * <p>
 * 解释：把最后一位反向旋转一次即可 "0000" -> "0009"。
 * <p>
 * 示例 3:
 * <p>
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * <p>
 * 输出：-1
 * <p>
 * 解释：无法旋转到目标数字且不被锁定。
 * <p>
 * 提示：
 * <p>
 * 1 <= deadends.length <= 500
 * <p>
 * deadends[i].length == 4
 * <p>
 * target.length == 4
 * <p>
 * target 不在 deadends 之中
 * <p>
 * target 和 deadends[i] 仅由若干位数字组成
 */
public class Solution042 {


    public static void main(String[] args) {
        Solution042 solution042 = new Solution042();
        String[] deadends = new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        System.out.println(solution042.openLock(deadends, "8888"));
    }

    public int openLock(String[] deadends, String target) {
        // 记录需要跳过的死亡密码
        Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));
        // 记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();
        return bfsV2(target, deadendsSet, visited);
    }

    // 双写bfs
    private int bfsV2(String target, Set<String> deadendsSet, Set<String> visited) {
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add("0000");
        q2.add(target);
        visited.add("0000");
        int step = 0;

        while (!q1.isEmpty() && !q2.isEmpty()) {
            // 哈希集合在遍历的过程中不能修改，用 temp 存储扩散结果
            Set<String> temp = new HashSet<>();

            /* 将 q1 中的所有节点向周围扩散 */
            for (String cur : q1) {
                /* 判断是否到达终点 */
                if (deadendsSet.contains(cur)) continue;
                if (q2.contains(cur)) return step;

                visited.add(cur);

                /* 将一个节点的未遍历相邻节点加入集合 */
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) temp.add(up);
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) temp.add(down);
                }
            }


            step++;
            // temp 相当于 q1
            // 这里交换 q1 q2，下一轮 while 就是扩散 q2
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }
    private int bfs(String target, Set<String> deadendsSet, Set<String> visited) {
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");
        int count = 0;

        while (!q.isEmpty()) {
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                assert cur != null;
                if (deadendsSet.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return count;
                }
                /* 将一个节点的相邻节点加入队列 */
                for (int j = 0; j < 4; j++) {
                    String plusOne = plusOne(cur, j);
                    String minusOne = minusOne(cur, j);

                    if (!visited.contains(plusOne)) {
                        visited.add(plusOne);
                        q.offer(plusOne);
                    }

                    if (!visited.contains(minusOne)) {
                        visited.add(minusOne);
                        q.offer(minusOne);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    // 将 s[j] 向上拨动一次
    private String plusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '9') {
            chars[j] = '0';
        } else {
            chars[j] += 1;
        }
        return String.copyValueOf(chars);
    }

    // 将 s[j] 向下拨动一次
    private String minusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '0') {
            chars[j] = '9';
        } else {
            chars[j] -= 1;
        }
        return String.copyValueOf(chars);
    }
}
