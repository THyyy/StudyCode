package algorithm.leetcode.everyday;

/**
 * 每日一题——加油站
 *
 * @author yuancome
 * @date 2020/11/18
 */

public class Day42 {
    private int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int remain = gas[i];
            int j = i;
            // 当前邮箱汽油能否跑到下一个站
            while (remain - cost[i] > 0) {
                // 到下一个站时能否有足够的汽油
                remain = remain - cost[j] + gas[(j + 1) % n];
                j = (j + 1) % n;
                // 是否回到了原来的汽油站
                if (j == i) {
                    return i;
                }
            }
        }
        // 没有回到原来的汽油站则返回 -1
        return -1;
    }

    /**
     * 最优解：当油箱可以为负数时，把最低值作为判断
     * 如果大于等于 0，则索引 + 1，为解
     * @param gas
     * @param cost
     * @return
     */
    private int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < n; i++) {
            spare = (spare + gas[i] - cost[i]);
            if (spare < minSpare) {
                minIndex = i;
                minSpare = spare;
            }
        }
        return spare < 0? -1: (minIndex + 1) % n;
    }
}
