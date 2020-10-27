package algorithm.leetcode.everyday;

/**
 * 每日一题——有多少小于当前数字的数字
 *
 * @author yuancome
 * @date 2020/10/26
 */

public class Day19 {
    private int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] > nums[j]) {
                    cur++;
                }
            }
            result[i] = cur;
        }
        return result;
    }
}
