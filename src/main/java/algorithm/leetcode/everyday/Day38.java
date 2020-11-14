package algorithm.leetcode.everyday;

/**
 * 每日一题——数组的相对排序
 *
 * @author yuancome
 * @date 2020/11/14
 */

public class Day38 {
    private int[] relativeSortArray(int[] arr1, int[] arr2) {
        int size = 0;
        for (int i : arr1) {
            size = Math.max(i, size);
        }

        int[] arr = new int[size + 1];
        for (int i : arr1) {
            arr[i]++;
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int i : arr2) {
            for (int j = 0; j < arr[i]; j++) {
                ans[index++] = i;
            }
            arr[i] = 0;
        }

        for (int i = 0; i <= size; i++) {
            for (int j = 0; j < arr[i]; j++) {
                ans[index++] = i;
            }
        }
        return ans;
    }
}
