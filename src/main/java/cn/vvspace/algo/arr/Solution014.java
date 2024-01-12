package cn.vvspace.algo.arr;

/**
 * <a href="https://leetcode.cn/problems/reverse-string/description/">344. 反转字符串</a>
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 */
public class Solution014 {

    public static void main(String[] args) {
        char[] s = "hello".toCharArray();
        reverseString(s);
        System.out.println(new String(s));
    }

    public static void reverseString(char[] s) {
        int low = 0, hight = s.length - 1;

        while (low <= hight) {
            char tmp = s[low];
            s[low] = s[hight];
            s[hight] = tmp;
            low++;
            hight--;
        }
    }
}
