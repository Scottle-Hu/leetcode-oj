package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * leetcode: https://leetcode.com/problems/valid-parentheses/
 * result:
 */
public class ValidParentheses {

    private Map<Character, Integer> relation = new HashMap<>();

    {
        relation.put('(', 0);
        relation.put(')', 0);
        relation.put('[', 1);
        relation.put(']', 1);
        relation.put('{', 2);
        relation.put('}', 2);
    }

    public boolean isValid(String s) {
        if (s == null || s == "") {
            return true;
        }
        char[] chrs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chrs) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() != c && relation.get(stack.peek()).equals(relation.get(c))) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}
