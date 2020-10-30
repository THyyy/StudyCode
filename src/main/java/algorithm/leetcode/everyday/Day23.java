package algorithm.leetcode.everyday;

/**
 * 每日一题——岛屿的周长
 *
 * @author yuancome
 * @date 2020/10/30
 */

public class Day23 {
    private int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // 上边
                    if (i == 0 || grid[i - 1][j] == 0) {
                        res++;
                    }
                    // 下边
                    if (i == grid.length - 1 || grid[i + 1][j] == 0) {
                        res++;
                    }
                    // 左边
                    if (j == 0 || grid[i][j - 1] == 0) {
                        res++;
                    }
                    // 右边
                    if (j == grid[i].length - 1 || grid[i][j + 1] == 0) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 利用边贴合少 2 周长的特性
     *
     * @param grid
     * @return
     */
    private int islandPerimeter2(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;
        int res = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    // 当上边方格也是1时，两个边贴合，少了2周长
                    if (i > 0 && grid[i - 1][j] == 1) {
                        res -= 2;
                    }
                    // 当左边方格也是1时，两个边贴合，少了2周长
                    if (j > 0 && grid[i][j - 1] == 1) {
                        res -= 2;
                    }
                }
            }
        }
        return res;
    }
}
