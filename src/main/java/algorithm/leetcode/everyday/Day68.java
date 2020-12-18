package algorithm.leetcode.everyday;

/**
 * 每日一题——找不同
 *
 * @author tanheyuan
 * @since 2020/12/18
 */

public class Day68 {
    private char findTheDifference(String s, String t) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars[c - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            chars[c - 'a']--;
            if (chars[c - 'a'] < 0) {
                return c;
            }
        }
        return ' ';
    }

    private char findTheDifference2(String s, String t) {
        int sSum = 0;
        int tSum = 0;

        for (int i = 0; i < s.length(); i++) {
            sSum += s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            tSum += t.charAt(i);
        }
        return (char)(tSum - sSum);
    }

    private char findTheDifference3(String s, String t) {
        char c = t.charAt(t.length() - 1);

        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
}
