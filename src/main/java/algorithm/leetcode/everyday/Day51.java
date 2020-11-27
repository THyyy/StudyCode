package algorithm.leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 每日一题——四数相加 II
 *
 * @author yuancome
 * @date 2020/11/27
 */

public class Day51 {
    private int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // 存储 A B 数组相加的所有结果
        Map<Integer,Integer> count = new HashMap<>();
        for (int i : A) {
            for (int i1 : B) {
                count.put(i + i1, count.getOrDefault(i + i1, 0) + 1);
            }
        }
        int ans = 0;
        for (int i : C) {
            for (int i1 : D) {
                // 如果 Map 存在 A + B 的相反结果即相加为 0，添加存在的结果数
                if (count.containsKey(-(i + i1))) {
                    ans += count.get(-(i + i1));
                }
            }
        }
        return ans;
    }
}
