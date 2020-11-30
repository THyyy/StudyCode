package algorithm.leetcode;

/**
 * 排除数组的重复项
 *
 * @author yuancome
 * @date 2020/11/30
 */

public class RemoveDuplicates {
    private int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
