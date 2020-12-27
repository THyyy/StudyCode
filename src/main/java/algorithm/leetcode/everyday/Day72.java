package algorithm.leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 每日一题——同构字符串
 *
 * @author yuancome
 * @date 2020/12/27
 */

public class Day72 {
    private boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // map 不包含 s 字符串吧该字符时判断 t 字符串
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                // 构造 s.charAt(i) - t.charAt(i) 的 K - V 结构
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
