package algorithm.leetcode.everyday;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 每日一题——独一无二的出现次数
 *
 * @author yuancome
 * @date 2020/10/28
 */

public class Day21 {
    private boolean uniqueOccurrences(int[] arr) {
        // 将数组转换为 Map
        Map<Integer, Integer> current = new HashMap<>();
        for (int i : arr) {
            current.put(i, current.getOrDefault(i, 0) + 1);
        }

        // 把结果存到 Set 中，如果最后 Set 集合中的大小不等于 Map 中的大小，意味着有重复
        Set<Integer> times = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : current.entrySet()) {
            times.add(entry.getValue());
        }
        return times.size() == current.size();
    }

    /**
     * 利用java 1.8 lambda特性
     * @param arr
     * @return
     */
    private boolean uniqueOccurrencesBy8(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr) {
            map.merge(i, 1, Integer::sum);
        }

        int i1 = map.values().stream().distinct().mapToInt(i -> i).sum();
        int i2 = map.values().stream().mapToInt(i -> i).sum();
        return i1 == i2;
    }
}
