package algorithm.leetcode.everyday;

/**
 * 每日一题——翻转矩阵后的得分
 *
 * @author yuancome
 * @date 2020/12/7
 */

public class Day61 {
    private int matrixScore(int[][] A) {
        // 一维数组长度
        int m = A.length;
        // 二维数组长度
        int n = A[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            // 如果第 i 行以 0 开头
            if (A[i][0] == 0) {
                // 行翻转
                for (int j = 0; j < n; j++) {
                    A[i][j] ^= 1;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int cnt = 0;
            // 统计第 j 列有多少个 1
            for (int i = 0; i < m; i++) {
                cnt += A[i][j];
            }
            // max(cnt, m - cnt) 表示这个位置最多有多少个 1
            // 然后 1<<(n-j-1) 表示这个位置的 1 的大小，二进制 2 的 n - 1 次方
            result += Math.max(cnt, m - cnt) * (1 << (n - j - 1));
        }
        return result;
    }
}
