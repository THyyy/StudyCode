package algorithm.leetcode.everyday;

/**
 * 每日一题——分割等和子集
 *
 * @author yuancome
 * @date 2020/10/11
 */

public class Day4 {
    private boolean canPartition(int[] nums) {
        // 分割成两个等和子集，即每个子集元素和为原集合的一半 -> 原集合元素和为偶数
        int length = nums.length;
        if (length < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 元素集合为奇数时，直接返回false
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        // 初始化动态数组
        boolean[][] dp = new boolean[length][target + 1];
        // 第一个数满足原集合和一半时，直接返回true
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= target; j++) {
                // 状态转移方程：dp[i][j] = dp[i - 1][j]（前 i - 1 个数已经满足条件时） or dp[i - 1][j - nums[i]]（前 i 个数刚好满足条件时）
                dp[i][j] = dp[i - 1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[length - 1][target];
    }
}
