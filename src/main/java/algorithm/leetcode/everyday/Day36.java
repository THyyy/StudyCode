package algorithm.leetcode.everyday;

/**
 * 每日一题——按奇偶排序数组 II
 *
 * @author yuancome
 * @date 2020/11/12
 */

public class Day36 {
    private int[] sortArrayByParityII(int[] A) {
        int length = A.length;
        int j = 1;
        for (int i = 0; i < length; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
