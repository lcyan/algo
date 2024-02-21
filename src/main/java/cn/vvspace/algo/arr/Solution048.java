package cn.vvspace.algo.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/">3. 无重复字符的最长子串</a>
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * <p>
 * 输出: 3
 * <p>
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * <p>
 * 输出: 1
 * <p>
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * <p>
 * 输出: 3
 * <p>
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * <p>
 * s 由英文字母、数字、符号和空格组成
 */
public class Solution048 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        Solution048 solution048 = new Solution048();
        System.out.println(solution048.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        char[] sArray = s.toCharArray();
        int sLen = sArray.length;

        int left = 0, right = 0;
        int len = -1;
        Map<Character, Integer> window = new HashMap<>();

        while (right < sLen) {
            char c = sArray[right];
            right++;

            window.put(c, window.getOrDefault(c, 0) + 1);

            if (window.get(c) > 1) {
                if (right - left > len) {
                    len = right - left;
                    System.out.printf("%d -> %d%n", left, right - left);
                }

                char d = sArray[left];
                left++;
                window.put(d, window.get(d) - 1);
            }
        }
        return len;
    }
}
