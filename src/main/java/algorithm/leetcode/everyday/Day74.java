package algorithm.leetcode.everyday;

/**
 * 每日一题——按要求补齐数组
 *
 * @author yuancome
 * @date 2020/12/29
 */

public class Day74 {
    private int minPatches(int[] nums, int n) {
        int patches = 0;
        long x = 1;
        int length = nums.length;
        int index = 0;
        while (x <= n) {
            if (index < length && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;
                patches++;
            }
        }
        return patches;
    }
}
