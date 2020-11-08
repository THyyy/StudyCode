package algorithm.leetcode.everyday;

/**
 * 每日一题——买卖股票的最佳时机 II
 *
 * @author yuancome
 * @date 2020/11/8
 */

public class Day32 {
    private int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                result += (prices[i] - prices[i - 1]);
            }
        }
        return result;
    }

    // 动态规划算法
    private int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
