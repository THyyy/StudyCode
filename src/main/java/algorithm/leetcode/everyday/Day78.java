package algorithm.leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 每日一题——斐波那契数
 *
 * @author tanheyuan
 * @since 2021/1/4
 */

public class Day78 {
    private int fib(int n) {
        Map<Integer, Integer> record = new HashMap<>();
        return process(n, record);
    }

    private int process(int n, Map<Integer, Integer> record) {
        if (n < 2) {
            return n;
        }
        if (record.get(n) != null) {
            return record.get(n);
        } else {
            record.put(n, process(n - 1, record) + process(n - 2, record));
        }
        return process(n - 1, record) + process(n - 2, record);
    }
}
