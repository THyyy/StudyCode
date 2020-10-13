package algorithm.leetcode;

import java.util.Stack;

/**
 * 有效的括号
 *
 * @author yuancome
 * @date 2020/10/13
 */

public class ValidParentheses {
    private boolean isValid(String s) {
        int length = s.length();
        // 字符串长度不是偶数时，直接返回false
        if (length % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    char temp = stack.peek();
                    if (c == ')' && temp == '(') {
                        stack.pop();
                    } else if (c == '}' && temp == '{') {
                        stack.pop();
                    } else if (c == ']' && temp == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
