package algorithm.leetcode.everyday;

import java.util.Arrays;

/**
 * 每日一题——三角形最大周长
 *
 * @author yuancome
 * @date 2020/11/29
 */

public class Day53 {
    private int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; --i) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }
}
