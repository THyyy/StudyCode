package algorithm.leetcode.everyday;

/**
 * 每日一题——N皇后2
 *
 * @author yuancome
 * @date 2020/10/17
 */

public class Day10 {
    // 皇后数量或者棋盘长宽
    int n;
    // 列数
    boolean[] col;
    // 右对角线
    boolean[] dial1;
    // 左对角线
    boolean[] dial2;

    private int totalNQueens(int n) {
        //初始化
        this.n = n;
        col = new boolean[n];
        dial1 = new boolean[2 * n - 1];
        dial2 = new boolean[2 * n - 1];
        return dfs(0);
    }

    private int dfs(int k) {
        int count = 0;
        // 当放置的皇后数量和 n 相等时直接返回
        if (k == n) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            // 当第i列放置皇后时，整列不可放置
            // 左对角线 列索引 - 行索引为固定值，因为存在负数，所以统一加上 (n - 1) 保证为正数
            // 右对角线 列索引 + 行索引为固定值
            if (!col[i] && !dial1[i + k] && !dial2[i - k + n - 1]) {
                // 递归
                col[i] = true;
                dial1[i + k] = true;
                dial2[i - k + n - 1] = true;
                count += dfs(k + 1);
                // 回溯
                col[i] = false;
                dial1[i + k] = false;
                dial2[i - k + n - 1] = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Day10().totalNQueens(8));
    }
}
