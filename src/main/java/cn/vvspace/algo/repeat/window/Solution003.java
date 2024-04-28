package cn.vvspace.algo.repeat.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/">438. 找到字符串中所有字母异位词</a>
 */
public class Solution003 {

    public static void main(String[] args) {
        String s = "baa", p = "aa";
        System.out.println(new Solution003().findAnagrams(s, p));
    }

    public List<Integer> findAnagrams(String s, String p) {
        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }

                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }

        return res;
    }
}
