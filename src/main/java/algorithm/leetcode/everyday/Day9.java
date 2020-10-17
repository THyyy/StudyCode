package algorithm.leetcode.everyday;

/**
 * 每日一题——有序数组的平方
 *
 * @author yuancome
 * @date 2020/10/16
 */

public class Day9 {
    private int[] sortedSquares(int[] A) {
        // 本题重点主要是解决负数部分，越小时，平方值越大问题
        int length = A.length;
        int[] result = new int[length];
        // 双指针，从头部指针和尾部指针进行遍历，比较两者平方值大小
        for (int i = 0, j = length - 1, pos = length - 1; i <= j; ) {
            if (A[i] * A[i] > A[j] * A[j]) {
                result[pos] = A[i] * A[i];
                i++;
            } else {
                result[pos] = A[j] * A[j];
                j--;
            }
            pos--;
        }
        return result;
    }
}
