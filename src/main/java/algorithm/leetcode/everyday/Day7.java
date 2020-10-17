package algorithm.leetcode.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 每日一题——寻找常用字符
 *
 * @author yuancome
 * @date 2020/10/14
 */

public class Day7 {
    private List<String> commonChars(String[] A) {
        // 初始化结果数组
        int[] minfreq = new int[26];
        // 使用最大数填充数组
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word : A) {
            // 记录每个字符出现次数的数组
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            // 把字母出现次数最小的存入结果数组
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        // 构造结果字符串列表
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
}