package algorithm.leetcode.everyday;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 每日一题—— Dota2 参议院
 *
 * @author yuancome
 * @date 2020/12/11
 */

public class Day65 {
    private String predictPartyVictory(String senate) {
        int n = senate.length();
        // 构造两个队列存储执行权力顺序
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        // 进行投票选择
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rad = radiant.poll();
            int dir = dire.poll();
            if (rad < dir) {
                radiant.offer(rad + n);
            }else {
                dire.offer(dir+n);
            }
        }
        return !radiant.isEmpty()? "Radiant":"Dire";
    }
}
