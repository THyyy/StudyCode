package algorithm.leetcode.everyday;

import java.util.Stack;

/**
 * 每日一题——有效的字母异位词
 *
 * @author yuancome
 * @date 2020/11/22
 */

public class Day46 {
    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] temp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - 'a']++;
            temp[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
