package algorithm.leetcode.everyday;


/**
 * 每日一题——移动零
 *
 * @author yuancome
 * @date 2020/11/19
 */

public class Day43 {
    private void moveZeroes(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
