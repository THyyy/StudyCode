package algorithm.leetcode.everyday;

/**
 * 每日一题——翻转字符串
 * 本题使用双指针进行遍历反转，实现空间复杂度为 O(1)
 *
 * @author yuancome
 * @date 2020/10/8
 */

public class Day1 {
    public void reverseString(char[] s) {
        for (int left = 0, right = s.length - 1; left <= right; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}
