package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode: https://leetcode.com/problems/generate-parentheses/
 * result:
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        genOnePossible(ret, 0, new char[2 * n], n, 0);
        return ret;
    }

    private void genOnePossible(List<String> ret, int num, char[] sub, int n, int n2) {
        if (num == 2 * n) {
            ret.add(new String(sub));
            return;
        }
        if (n2 < n) {
            sub[num] = '(';
            genOnePossible(ret, num + 1, sub, n, n2 + 1);
        }
        if (num > 0 && num < 2 * n2) {
            sub[num] = ')';
            genOnePossible(ret, num + 1, sub, n, n2);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }
}
