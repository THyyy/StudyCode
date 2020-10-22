package algorithm.leetcode.everyday;

/**
 * 每日一题——长按键入
 *
 * @author yuancome
 * @date 2020/10/21
 */

public class Day14 {
    private boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else {
                if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                    j++;
                } else {
                    return false;
                }
            }
        }
        return i == name.length();
    }
}
