package algorithm.leetcode.everyday;

import java.util.Arrays;

/**
 * 每日一题——买卖股票的最佳时机 IV
 *
 * @author yuancome
 * @date 2020/12/29
 */

public class Day73 {
    private int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // 因为交易次数限制在交易日/2和k的最小值
        k = Math.min(k, n/2);
        // 初始化基础数据
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        // 初始化状态
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i <= k; i++) {
            buy[i] = sell[i] = Integer.MIN_VALUE / 2;
        }

        // 动态规划状态转移过程
        for (int i = 1; i < prices.length; i++) {
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);
            }
        }
        // 返回最大值
        return Arrays.stream(sell).max().getAsInt();
    }
}
