package algorithm.leetcode;

/**
 * Pow(x, n)
 *
 * @author yuancome
 * @date 2020/11/5
 */

public class Pow {
    private double myPow(double x, int n) {
        long N = n;
        // 递归
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        // 快速幂，当 N 为偶数时，直接返回结果 y * y，当 N 为奇数时，返回结果为 y * y * x
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
