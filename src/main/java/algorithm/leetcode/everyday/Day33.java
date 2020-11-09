package algorithm.leetcode.everyday;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 每日一题——最接近原点的 K 个点
 *
 * @author yuancome
 * @date 2020/11/9
 */

public class Day33 {
    private int[][] kClosest(int[][] points, int K) {
        // 欧几里得距离就是两点间的直线距离，题目为原点则距离 X = (x^2 + y^2)^(1/2)
        // 对原数组进行排序即可
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
            }
        });
        // 返回前 K 个点
        return Arrays.copyOfRange(points, 0, K);
    }
}
