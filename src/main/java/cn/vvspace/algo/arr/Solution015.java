package cn.vvspace.algo.arr;

/**
 * <a href="https://leetcode.cn/problems/XltzEq/description/">LCR 018. 验证回文字符串</a>
 * <p>
 * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 本题中，将空字符串定义为有效的 回文串 。
 * <p>
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 */
public class Solution015 {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }


    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        // 0 1 2 3 4 5
        char[] arr = s.toLowerCase().toCharArray();
        int slow = 0, hight = arr.length - 1;

        while (slow <= hight) {
            if (isIllegalChar(arr[slow])) {
                slow++;
                continue;
            }
            if (isIllegalChar(arr[hight])) {
                hight--;
                continue;
            }

            if (arr[slow] != arr[hight]) {
                return false;
            }
            slow++;
            hight--;
        }
        return true;
    }

    public static boolean isIllegalChar(char c) {
        return (c < '0' || c > '9') && (c < 'a' || c > 'z') && (c < 'A' || c > 'Z');
    }
}
