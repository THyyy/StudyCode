package algorithm.leetcode.everyday;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 每日一题——最大间距
 *
 * @author yuancome
 * @date 2020/11/26
 */

public class Day50 {
    private int maximumGap(int[] nums) {
        if (nums == null && nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, (nums[right] - nums[left]));
            left++;
            right++;
        }
        return ans;
    }
}
