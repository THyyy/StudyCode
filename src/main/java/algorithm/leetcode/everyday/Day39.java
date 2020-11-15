package algorithm.leetcode.everyday;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 每日一题——移掉K位数字
 *
 * @author yuancome
 * @date 2020/11/15
 */

public class Day39 {
    private String removeKDigits(String num, int k) {
        char[] chars = num.toCharArray();
        Deque<Character> deque = new LinkedList<>();
        int length = chars.length;
        // 先将一个数字添加到双端队列
        for (int i = 0; i < length; i++) {
            char aChar = chars[i];
            // 如果队列不为空且 k > 0，而且最后一位数比目前的数字大则替换最后一位数
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > aChar) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(aChar);
        }
        // 判断是否移除 k 位数
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        boolean firstZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            // 开头为 0 的时候跳过
            if (firstZero && digit == '0') {
                continue;
            }
            firstZero = false;
            sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
