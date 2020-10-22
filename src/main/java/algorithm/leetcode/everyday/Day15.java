package algorithm.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 每日一题——划分字母区间
 *
 * @author yuancome
 * @date 2020/10/22
 */

public class Day15 {
    private List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            // 存储字母的最大索引位置
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < length; i++) {
            // end 和 字母最大索引比较，取最大值
            end = Math.max(end, last[S.charAt(i)  - 'a']);
            if (i == end) {
                // 片段长度等于 end - start + 1
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
