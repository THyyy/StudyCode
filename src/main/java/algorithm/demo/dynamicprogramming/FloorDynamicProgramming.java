package algorithm.demo.dynamicprogramming;

/**
 * 动态规划：楼梯问题
 * 一个楼梯有 10 级台阶，每一步可以跨 1 级或 2 级台阶，请问走到 10 级台阶有多少种走法
 *
 * @author yuancome
 * @date 2020/8/19
 */

public class FloorDynamicProgramming {

    /**
     * 动态规划实现方法
     * 时间复杂度 O(n)，空间复杂度 O(1)
     *
     * @param n
     * @return
     */
    private int getWays(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int pre = 1;
        int last = 2;
        int temp = pre + last;
        for(int i = 3; i < n; i++) {
            temp = pre + last;
            pre = last;
            last = temp;
        }
        return temp;
    }
}
