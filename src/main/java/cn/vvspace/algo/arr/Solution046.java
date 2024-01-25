package cn.vvspace.algo.arr;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/permutation-in-string/description/">567. 字符串的排列</a>
 * <p>
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * <p>
 * 输出：true
 * <p>
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * <p>
 * 示例 2：
 * <p>
 * 输入：s1= "ab" s2 = "eidboaoo"
 * <p>
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s1.length, s2.length <= 104
 * <p>
 * s1 和 s2 仅包含小写字母
 */
public class Solution046 {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        Solution046 solution046 = new Solution046();
        System.out.println(solution046.checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        Map<Character, Integer> needs = new HashMap<>(), window = new HashMap<>();
        for (char c : s1Array) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        int s1Len = s1Array.length, s2Len = s2Array.length;

        while (right < s2Len) {
            char c = s2Array[right];
            right++;
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(needs.get(c))) {
                    valid++;
                }
            }

            while (right - left >= s1Len) { // 固定窗口大小，一旦发现大于s1Len就开始缩小

                if (valid == needs.size()) {
                    return true;
                }

                char d = s2Array[left];
                left++;

                if (needs.containsKey(d)) {
                    if (window.get(d).equals(needs.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return false;
    }
}
