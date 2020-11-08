package algorithm.leetcode.everyday;

/**
 * 每日一题——有效的山脉数组
 *
 * @author yuancome
 * @date 2020/11/3
 */

public class Day27 {
    private boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int length = A.length;
        int i = 0;
        while ((i < length - 1) && A[i] < A[i + 1]) {
            i++;
        }
        if (i == 0 || i == length - 1) {
            return false;
        }
        while ((i < length - 1) && A[i] > A[i + 1]) {
            i++;
        }
        return i == length - 1;
    }
}
