package algorithm.leetcode.everyday;

/**
 * 每日一题——数组中的最长山脉
 *
 * @author yuancome
 * @date 2020/10/25
 */

public class Day18 {
    private int longestMountain(int[] A) {
        // 首先通过查找山脚，使用双指针
        int n = A.length;
        int ans = 0;
        int left = 0;
        // 左山脚 + 2 必须要小于 n，才能使山长度大于 3
        while (left + 2 < n) {
            // 右指针必须是左指针 + 1，快一步
            int right = left + 1;
            if (A[left] < A[left + 1]) {
                // 找到不单调递增的节点索引
                while (right + 1 < n && A[right] < A[right + 1]) {
                    ++right;
                }
                // 当右山脚单调递减时，枚举最大长度
                if (right < n - 1 && A[right] > A[right + 1]) {
                    while (right + 1 < n && A[right] > A[right + 1]) {
                        ++right;
                    }
                    // 通过右指针 - 左指针 + 1 得出山脉长度
                    ans = Math.max(ans, right - left + 1);
                } else {
                    ++right;
                }
            }
            // 如果左山脚不成立则左指针等于右指针
            left = right;
        }
        // 返回结果
        return ans;
    }
}
