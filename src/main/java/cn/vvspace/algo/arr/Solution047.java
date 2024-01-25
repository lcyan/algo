package cn.vvspace.algo.arr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/">438. 找到字符串中所有字母异位词 </a>
 * <p>
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * <p>
 * 输出: [0,6]
 * <p>
 * 解释:
 * <p>
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * <p>
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "abab", p = "ab"
 * <p>
 * 输出: [0,1,2]
 * <p>
 * 解释:
 * <p>
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * <p>
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * <p>
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, p.length <= 3 * 104
 * <p>
 * s 和 p 仅包含小写字母
 */
public class Solution047 {

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        Solution047 solution047 = new Solution047();
        System.out.println(solution047.findAnagrams(s, p));
    }

    public List<Integer> findAnagrams(String s, String p) {
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        int sLen = sArray.length, pLen = pArray.length;

        Map<Character, Integer> needs = new HashMap<>(), window = new HashMap<>();

        for (char c : pArray) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        while (right < sLen) {
            char c = sArray[right];
            right++;
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }

            if (right - left >= pLen) {

                if (valid == needs.size()) {
                    res.add(left);
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
        return res;
    }

}
