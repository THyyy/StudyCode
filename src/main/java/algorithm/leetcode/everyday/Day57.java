package algorithm.leetcode.everyday;

/**
 * 每日一题——计数质数计数质数
 *
 * @author yuancome
 * @date 2020/12/3
 */

public class Day57 {
    private int countPrimes(int n) {
        int count = 0;
        //初始全都false
        boolean[] flag = new boolean[n];

        for (int i = 2; i < n; i++) {
            if (!flag[i]) {
                count++;
                for (int j = 1; j * i < n; j++) {
                    flag[j * i] = true;
                }
            }
        }
        return count;
    }
}
