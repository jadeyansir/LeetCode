import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * @author yan
 * @date 2022/7/3
 */
public class Stack_20 {
    class Solution {
        public boolean isValid(String s) {
            if (s == null) {
                return false;
            }
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char charAt = s.charAt(i);
                //栈为空直接插入栈
                if (stack.isEmpty()) {
                    stack.push(charAt);
                    continue;
                }
                if (charAt == ')') {
                    Character pop = stack.pop();
                    if (pop != '(') {
                        return false;
                    }
                } else if (charAt == '}') {
                    Character pop = stack.pop();
                    if (pop != '{') {
                        return false;
                    }
                } else if (charAt == ']') {
                    Character pop = stack.pop();
                    if (pop != '[') {
                        return false;
                    }
                } else {
                    stack.push(charAt);
                }
            }
            if (stack.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
    }
}
