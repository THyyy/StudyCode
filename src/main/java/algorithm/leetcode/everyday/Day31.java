package algorithm.leetcode.everyday;

/**
 * 每日一题——区间和的个数
 *
 * @author yuancome
 * @date 2020/11/7
 */

public class Day31 {
    // 暴力破解
    private int countRangeSum(int[] nums, int lower, int upper) {
        int res = 0;
        if (nums.length < 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            long sum = 0L;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (lower <= sum && sum <= upper) {
                    res++;
                }
            }
        }
        return res;
    }

    // 前缀和暴力法
    private static int countRangeSum2(int[] nums, int lower, int upper) {
        int res = 0;
        if (nums.length < 1) {
            return 0;
        }
        long sum = 0L;
        long[] sums = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                long temp = 0L;
                if (i == 0) {
                    temp = sums[j];
                } else {
                    temp = sums[j] - sums[i - 1];
                }
                System.out.println(temp);
                if (lower <= temp && temp <= upper) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 5, -1};
        int l = -2;
        int r = 2;
        countRangeSum2(nums,l,r);
    }
}
