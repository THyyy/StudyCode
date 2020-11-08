package algorithm.leetcode.everyday;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 每日一题——两个数组的交集
 *
 * @author yuancome
 * @date 2020/11/2
 */

public class Day26 {
    private int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i) && !list.contains(i)) {
                list.add(i);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     * 空间换时间，时间复杂度最优解
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] intersection2(int[] nums1, int[] nums2) {
        // 空间最大值
        int max = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            max = max > nums1[i] ? max : nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            max = max > nums2[i] ? max : nums2[i];
        }
        // 构造 boolean 数组
        boolean[] nums = new boolean[max + 1];
        for (int i = 0; i < nums1.length; i++) {
            nums[nums1[i]] = true;
        }
        boolean[] num = new boolean[max + 1];
        for (int i = 0; i < nums2.length; i++) {
            if (nums[nums2[i]]) {
                num[nums2[i]] = true;
            }
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i]) {
                arr.add(i);
            }
        }
        // 构造结果 int 数组
        int[] out = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            out[i] = arr.get(i);
        }
        return out;
    }
}
