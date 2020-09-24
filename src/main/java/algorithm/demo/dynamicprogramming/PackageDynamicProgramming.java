package algorithm.demo.dynamicprogramming;

/**
 * 动态规划：背包问题
 * 一个背包总容量为 V，现在有 N 类物品，第 i 类物品的重量为 weight[i]，价值为 value[i]
 * 那么怎么往该背包里装东西，才能使得最终包里的物品价值最大。
 * 这里装物品主要包含三种装法：
 * 0 - 1 背包：每类物品只能装一次
 * 多重背包：每类物品都有个数限制，第 i 类物品最多安装 num[i] 次
 * 完全背包：每类物品可以无限次装进背包里
 *
 * @author yuancome
 * @date 2020/8/19
 */

public class PackageDynamicProgramming {

    private String zeroOnePackage(int N, int V, int[] weight, int[] value) {

        // 初始化dp二维数组
        int[][] dp = new int[N + 1][V + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                // 先判断当前第 i 个物品能否装入背包
                // 因为一开始 i 是从 1 开始，所以weight[i-1]、value[i-1]才是第 i 个物品的对应值
                if (weight[i - 1] > j) {
                    //如果大于背包容量则
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - weight[i - 1]] + value[i - 1], dp[i - 1][j]);
                }
            }
        }
        // 此时背包能装物品的最大价值
        int maxValue = dp[N][V];
        // 计算此时背包装的所有物品编号
        int j = V;
        StringBuilder productStr = new StringBuilder();
        for (int i = N; i > 0; i--) {
            // 当 dynamincProgramming[i][j] > dynamincProgramming[i - 1][j]时，第 i 件商品是在背包内的
            if (dp[i][j] > dp[i - 1][j]) {
                productStr.append(i).append(" ");
                j -= weight[i];
            }
            // 当背包容量为 0 时，此时背包内的物品已经统计完成
            if (j == 0) {
                break;
            }
        }
        return productStr.toString();
    }

    /**
     * 0 - 1 背包优化版本
     *
     * @param N
     * @param V
     * @param weight
     * @param value
     * @return
     */
    private int zeroOnePackage2(int N, int V, int[] weight, int[] value) {
        int[] dp = new int[V + 1];
        for (int i = 1; i < N + 1; i++) {
            //逆序实现
            for (int j = V; j >= weight[i - 1]; j--) {
                // dp[j]等于dp[j - weight[i - 1]]加上value[i - 1]和 dp[j] 取最大值
                dp[j] = Math.max(dp[j - weight[i - 1]] + value[i - 1], dp[j]);
            }
        }
        return dp[V];
    }

    private void manyPackage(int N, int V, int[] weight, int[] value, int[] num) {
        // 初始化dp二维数组
        int[][] dp = new int[N + 1][V + 1];
        // 方便理解从 1 开始统计
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                // 当重量大于 j 时，无法装进背包
                if (weight[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //考虑物品的件数限制，取最小数量进行统计
                    int maxV = Math.min(num[i - 1], j / weight[i - 1]);
                    // 多了商品数量则多了一步容量计算，j - k * weight[i - 1]
                    // 价值则多了一个 k * value[i - 1]
                    for (int k = 0; k < maxV + 1; k++) {
                        // 此处判断是背包可能有商品 1、2、3，不全是 1、1、1
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * weight[i - 1]] + k * value[i - 1]);
                    }
                }
            }
        }
    }
}
