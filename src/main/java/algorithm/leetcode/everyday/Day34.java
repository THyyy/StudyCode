package algorithm.leetcode.everyday;

/**
 * 每日一题——下一个排列
 *
 * @author yuancome
 * @date 2020/11/10
 */

public class Day34 {
    private void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 从后往前找，找到递减的开头 num[i]
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            // 当 i > 0 是说明整个数组不是递减数组，则从后往前找，找到比 num[i] 大的 num[j]
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            // 交换 num[i] 和 num[j] 的位置
            swap(nums, i, j);
        }
        // 然后把索引 i+1 之后的数进行翻转（因为确定是递减，小数在前）
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
