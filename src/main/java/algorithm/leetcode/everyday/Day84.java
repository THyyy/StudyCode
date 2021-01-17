package algorithm.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 每日一题——可被 5 整除的二进制前缀
 *
 * @author yuancome
 * @date 2021/1/14
 */

public class Day84 {
    private List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();
        int prefix = 0;
        int n = A.length;
        for (int i = 0; i < A.length; i++) {
            int i1 = A[i];
            prefix = ((prefix << 1) + i1) % 5;
            ans.add(prefix == 0);
        }
        return ans;
    }
}
