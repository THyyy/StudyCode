package algorithm.leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 每日一题——字符串中的第一个唯一字符
 *
 * @author yuancome
 * @date 2020/12/23
 */

public class Day70 {
    private int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
             char c = s.charAt(i);
             if (map.get(c) == 1) {
                 return i;
             }
        }
        return -1;
    }
}
