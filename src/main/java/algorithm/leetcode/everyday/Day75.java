package algorithm.leetcode.everyday;

import java.util.PriorityQueue;

/**
 * 每日一题——最后一块石头的重量
 *
 * @author yuancome
 * @date 2020/12/30
 */

public class Day75 {
    private int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
