package algorithm.leetcode.everyday;

/**
 * 每日一题——买卖股票的最佳时机含手续费
 *
 * @author tanheyuan
 * @since 2020/12/17
 */

public class Day67 {
    private int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] -= prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    private int maxProfit2(int[] prices, int fee) {
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] -= prices[0];
        for (int i = 1; i < prices.length; i++) {
            int temp = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            dp[1] = Math.max(dp[1], temp - prices[i]);
        }
        return dp[0];
    }
}
