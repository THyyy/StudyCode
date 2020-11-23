package algorithm.leetcode.everyday;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 每日一题——用最少数量的箭引爆气球
 *
 * @author yuancome
 * @date 2020/11/23
 */

public class Day47 {
    private int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        // 将右边界按升序排列
        Arrays.sort(points, (o1, o2) -> {
            if (o1[1] > o2[1]) {
                return 1;
            } else if (o1[1] < o2[1]){
                return -1;
            } else {
                return 0;
            }
        });
        // 初始化结果、以及起始值
        int ans = 1;
        int pos = points[0][1];
        // 当下个气球的左边界大于上一个气球右边界时，则需要新的箭
        for (int[] point : points) {
            if (point[0] > pos) {
                pos = point[1];
                ans++;
            }
        }
        return ans;
    }
}
