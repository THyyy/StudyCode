package algorithm.leetcode.everyday;

/**
 * 每日一题——整数转罗马数字
 *
 * @author yuancome
 * @date 2021/5/14
 */

public class Day85 {

    private String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
             int value = values[i];
             String symbol = symbols[i];
             // 此处使用 while 循环是因为输入 3 时需要循环处理 3 次
             while (num >= value) {
                 num -= value;
                 stringBuffer.append(symbol);
             }
            if (num == 0) {
                break;
            }
        }
        return stringBuffer.toString();
    }
}
