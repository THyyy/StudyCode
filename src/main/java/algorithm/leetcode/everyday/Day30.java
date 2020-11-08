package algorithm.leetcode.everyday;

import java.util.*;

/**
 * 每日一题——根据数字二进制下 1 的数目排序
 *
 * @author yuancome
 * @date 2020/11/6
 */

public class Day30 {
    private int[] sortByBits(int[] arr) {
        int[] bin = new int[10001];
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
            bin[i] = getBinCount(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (bin[o1] != bin[o2]) {
                    return bin[o1] - bin[o2];
                } else {
                    return o1 - o2;
                }
            }
        });
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private int getBinCount(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 2;
            x >>= 1;
        }
        return res;
    }
}
