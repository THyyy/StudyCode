package algorithm.leetcode.everyday;

/**
 * 每日一题——比较含退格字符串
 *
 * @author yuancome
 * @date 2020/10/19
 */

public class Day12 {
    private boolean backspaceCompare(String S, String T) {
        // 构造出两个含退格字符串的结果字符串进行比较
        return equalsString(S).equals(equalsString(T));
    }

    private String equalsString(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        // 遍历退格字符串
        for (int i = 0; i < S.length(); i++) {
            // 取出单个字符
            char c = S.charAt(i);
            // 如果不等于退格符，则拼接
            if (c != '#') {
                stringBuilder.append(c);
            } else {
                // 结果字符串大于0时去掉前一位
                if (stringBuilder.length() > 0) {
                    // 等于退格符则去掉前一位字符
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            }
        }
        // 返回结果字符串
        return stringBuilder.toString();
    }
}
