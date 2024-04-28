package cn.vvspace.algo.repeat.window;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/permutation-in-string/">567. 字符串的排列</a>
 */
public class Solution002 {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ccccbbbbaaaa";
        System.out.println(new Solution002().checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        int left = 0, right = 0;
        int valid = 0;

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            if (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }

                char d = s2.charAt(left);
                left++;

                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return false;
    }
}
