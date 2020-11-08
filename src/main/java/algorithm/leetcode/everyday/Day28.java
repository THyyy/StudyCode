package algorithm.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 每日一题——插入区间
 *
 * @author yuancome
 * @date 2020/11/4
 */

public class Day28 {
    private int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集，重新计算 left、right
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        // 因为并集部分还没有插入到列表中，此时插入
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        // 构造结果数组
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
