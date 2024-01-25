package cn.vvspace.algo.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/minimum-window-substring/description/">76. 最小覆盖子串</a>
 * <p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * <p>
 * 输出："BANC"
 * <p>
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * <p>
 * 输出："a"
 * <p>
 * 解释：整个字符串 s 是最小覆盖子串。
 * <p>
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * <p>
 * 输出: ""
 * <p>
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * <p>
 * 因此没有符合条件的子字符串，返回空字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == s.length
 * <p>
 * n == t.length
 * <p>
 * 1 <= m, n <= 105
 * <p>
 * s 和 t 由英文字母组成
 */
public class Solution045 {

    public static void main(String[] args) {
        Solution045 solution045 = new Solution045();
        System.out.println(solution045.minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Map<Character, Integer> needs = new HashMap<>(), window = new HashMap<>();
        int valid = 0; // 表示窗口中满足 needs 条件的字符个数
        for (char c : tArray) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        /*
            1、什么时候应该移动 right 扩大窗口？窗口加入字符时，应该更新哪些数据？
               -- valid != needs.size
            2、什么时候窗口应该暂停扩大，开始移动 left 缩小窗口？从窗口移出字符时，应该更新哪些数据？
               -- valid == needs.size
            3、我们要的结果应该在扩大窗口时还是缩小窗口时进行更新？
               -- 缩小
         */

        int sLen = sArray.length;
        int tLen = tArray.length;

        int left = 0, right = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;

        while (right < sLen) {
            char c = sArray[right];
            right++;
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(needs.get(c))) {
                    valid++; // 只有当 window[c] 和 need[c] 对应的出现次数一致时，才能满足条件，valid 才能 +1
                }
            }

            // 因为 IO 操作很耗时，可能导致超时
            System.out.printf("window: [%d, %d)\n", left, right);

            while (valid == needs.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = sArray[left];
                left++;
                if (needs.containsKey(d)) {
                    if (window.get(d).equals(needs.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
