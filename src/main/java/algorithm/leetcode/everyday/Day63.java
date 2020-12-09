package algorithm.leetcode.everyday;

/**
 * 每日一题——不同路径
 *
 * @author yuancome
 * @date 2020/12/9
 */

public class Day63 {
    private int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
}
