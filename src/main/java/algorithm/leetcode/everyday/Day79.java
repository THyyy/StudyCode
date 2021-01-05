package algorithm.leetcode.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 每日一题——较大分组的位置
 *
 * @author tanheyuan
 * @since 2021/1/5
 */

public class Day79 {
    private List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ret = new ArrayList<>();
        int n = s.length();
        int num = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    ret.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return ret;
    }
}
