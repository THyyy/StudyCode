package algorithm.leetcode.everyday;

import java.util.Arrays;

/**
 * 每日一题——根据身高重建队列
 *
 * @author yuancome
 * @date 2020/11/16
 */

public class Day40 {
    private static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                // 按身高升序
                return o1[0] - o2[0];
            } else {
                // 按 k 值降序
                return o2[1] - o1[1];
            }
        });
        int len = people.length;
        int[][] ans = new int[len][];
        for (int[] person : people) {
            // 存放的位置为 k + 1
            int space = person[1] + 1;
            for (int i = 0; i < len; i++) {
                if (ans[i] == null) {
                    // 从空位开始遍历替换，因为k是降序，所以k大的会在前面先插入了
                    space--;
                    if (space == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(reconstructQueue(people));
    }
}
