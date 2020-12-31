package algorithm.leetcode.everyday;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 每日一题——无重叠区间
 *
 * @author tanheyuan
 * @since 2020/12/31
 */

public class Day76 {
    private int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        // 先对子数组进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int n = intervals.length;
        int[] f = new int[n];
        // 只有一个子数组的话直接返回，所以从 1 开始
        Arrays.fill(f, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                // 如果后一个子数组的起始值大于前一个是数组的终止值则无重叠
                if (intervals[j][1] <= intervals[i][0]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        // 总子数组个数减去无重叠数组个数等于移除的数组个数
        return n - Arrays.stream(f).max().getAsInt();
    }
}
