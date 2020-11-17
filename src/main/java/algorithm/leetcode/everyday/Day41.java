package algorithm.leetcode.everyday;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 每日一题——距离顺序排列矩阵单元格
 *
 * @author yuancome
 * @date 2020/11/17
 */

public class Day41 {
    private int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ans = new int[R * C][];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans[i * C + j] = new int[]{i, j};
            }
        }
        Arrays.sort(ans, Comparator.comparingInt(o -> (Math.abs(o[0] - r0) + Math.abs(o[1] - c0))));
        return ans;
    }
}
