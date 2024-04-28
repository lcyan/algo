package cn.vvspace.algo.repeat.window;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/">3. 无重复字符的最长子串</a>
 */
public class Solution004 {

    public static void main(String[] args) {
    }


    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, res = 0;

        Map<Character, Integer> window = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;

                window.put(d, window.getOrDefault(d, 0) - 1);
            }

            res = Math.max(res, right - left);
        }
        return res;
    }
}
