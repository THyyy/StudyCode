package algorithm.leetcode.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 每日一题——自由之路
 *
 * @author yuancome
 * @date 2020/11/11
 */

public class Day35 {
    private int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        int wordCount = 26;
        // 26 个字母对应的位置列表
        List<Integer>[] pos = new List[wordCount];
        for (int i = 0; i < wordCount; ++i) {
            // 初始化字母列表
            pos[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; ++i) {
            // 添加每个字母的位置
            pos[ring.charAt(i) - 'a'].add(i);
        }
        // 初始化动态规划二维数组
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            // 填充动态规划二维数组
            Arrays.fill(dp[i], 0x3f3f3f);
        }
        for (int i : pos[key.charAt(0) - 'a']) {
            // 找出起步的位置 i
            dp[0][i] = Math.min(i, n - i) + 1;
        }
        // 从 key 的第二个字母开始进行动态规划
        for (int i = 1; i < m; ++i) {
            // 找到第二个字母的位置 j
            for (int j : pos[key.charAt(i) - 'a']) {
                // 找到前一个字母的位置 k
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    // 状态转移方程 dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }
        // 获取动态规划二维数组中 二维数组 的 最小值 返回
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }
}
