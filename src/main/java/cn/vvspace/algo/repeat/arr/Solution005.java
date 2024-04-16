package cn.vvspace.algo.repeat.arr;

/**
 * <a href="https://leetcode.cn/problems/reverse-string/description/">344. 反转字符串</a>
 */
public class Solution005 {

    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;

        while (left < right) {
            char tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;
            left++;
            right--;
        }
    }
}
