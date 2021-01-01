package algorithm.leetcode.everyday;

/**
 * 每日一题——种花问题
 *
 * @author yuancome
 * @date 2021/1/1
 */

public class Day77 {
    private boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int m = flowerbed.length;
        // 上一个种花的数组索引
        int prev = -1;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    count += i / 2;
                } else {
                    count += (i - prev - 2) / 2;
                }
                // 剪枝操作，达到 n 立即返回
                if (count >= n) {
                    return true;
                }
                prev = i;
            }
        }
        // 全为 0 和全为 1 的情况
        if (prev < 0) {
            count += (m + 1) / 2;
        } else {
            count += (m - prev - 1) / 2;
        }
        return count >= n;
    }

    private boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length;) {
            // 当前索引为 1 时跳两格
            if (flowerbed[i] == 1) {
                i += 2;
                // 跳格后下一个仍为 0 则可以种花
            } else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                count++;
                i += 2;
                // 不管当前的位置是什么，下一个为 1 就跳三格
            } else {
                i += 3;
            }
            // 剪枝操作
            if (count >= n) {
                return true;
            }
        }
        return count >= n;
    }
}
