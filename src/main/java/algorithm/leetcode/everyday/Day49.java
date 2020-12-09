package algorithm.leetcode.everyday;

/**
 * 每日一题——上升下降字符串
 *
 * @author yuancome
 * @date 2020/11/25
 */

public class Day49 {
    private String sortString(String s) {
        if (s.length() < 1) {
            return s;
        }
        int[] map = new int[26];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        while (stringBuilder.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (map[i]>0) {
                    stringBuilder.append((char) (i + 'a'));
                    map[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (map[i]>0) {
                    stringBuilder.append((char) (i + 'a'));
                    map[i]--;
                }
            }
        }
        return stringBuilder.toString();
    }
}
