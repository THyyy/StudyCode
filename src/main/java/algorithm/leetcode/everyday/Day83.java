package algorithm.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 每日一题——汇总区间
 *
 * @author yuancome
 * @date 2021/1/10
 */

public class Day83 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        // 起始索引
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            // 从 1 开始，便于下面 while 判断
            i++;
            // 获取区间的右边界索引
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(nums[low]);
            // 判断是否满足区间
            if (low < high) {
                stringBuilder.append("->");
                stringBuilder.append(nums[high]);
            }
            ans.add(stringBuilder.toString());
        }
        return ans;
    }
}
