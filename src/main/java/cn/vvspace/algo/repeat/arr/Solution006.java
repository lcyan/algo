package cn.vvspace.algo.repeat.arr;

/**
 * <a href="">判定回文字符串</a>
 */
public class Solution006 {

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }

        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
