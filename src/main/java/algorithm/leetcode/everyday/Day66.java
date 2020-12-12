package algorithm.leetcode.everyday;

/**
 * 每日一题——摆动序列
 *
 * @author yuancome
 * @date 2020/12/12
 */

public class Day66 {
    private int wiggleMaxLength(int[] nums) {
        int down = 1, up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;
        }
        return nums.length == 0 ? 0 : Math.max(down, up);
    }
}
