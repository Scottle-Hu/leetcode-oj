package leetcode;

/**
 * leetcode: https://leetcode.com/problems/longest-valid-parentheses/
 * result:
 *
 * @author huqj
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }
        int maxLength = 0;
        int i = 0;
        int start, end;
        while (i < s.length()) {
            start = s.indexOf("(", i);
            if (start == -1) {
                break;
            }
            end = start + 1;
            int f = 1;
            while (end < s.length()) {
                if (s.charAt(end) == '(') {
                    f++;
                } else if (s.charAt(end) == ')') {
                    f--;
                }
                end++;
                if (f == 0) {
                    maxLength = Math.max(maxLength, end - start);
                } else if (f < 0) {
                    i = end;
                    break;
                }
            }
            if (end >= s.length()) {
                i++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses(")()())"));
    }
}
