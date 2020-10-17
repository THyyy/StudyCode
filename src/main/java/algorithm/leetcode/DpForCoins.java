package algorithm.leetcode;

/**
 * 动态规划——硬币题
 * 有 n 个硬币，总价值 m 元，有 1 元、2 元、 5 元、10 元的硬币，
 * 有多少种组合成价值为 m 元？
 *
 * @author yuancome
 * @date 2020/10/15
 */

public class DpForCoins {
    private static int[] coins = {1, 2, 5, 10};

    private static int dp(int n, int m) {
        // 初始化 dp 数组
        int[][] dp = new int[n + 1][m + 1];
        // 初始化 0 个硬币 价值为 0 的组合数为 1
        dp[0][0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= n; i++) {
                for (int j = coin; j <= m; j++) {
                    // 状态转移方程
                    dp[i][j] += dp[i - 1][j - coin];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(dp(200,456));
    }
}
