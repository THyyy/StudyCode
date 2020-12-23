package algorithm.leetcode.everyday;

/**
 * 每日一题——分发糖果
 *
 * @author yuancome
 * @date 2020/12/24
 */

public class Day71 {
    private int candy(int[] ratings) {
        // 队列长度
        int n = ratings.length;
        // 从左到右分发糖果数量
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        // 从右到左分发糖果数量
        int right = 0;
        int ret = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            // 从左到右、从右到左两种方式取最大值
            ret += Math.max(left[i], right);
        }
        return ret;
    }
}
