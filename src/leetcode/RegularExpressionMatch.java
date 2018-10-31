package leetcode;

/**
 * leetcode: https://leetcode.com/problems/regular-expression-matching/
 * result: success
 *
 * @author huqj
 */
public class RegularExpressionMatch {

    public boolean isMatch(String s, String p) {
        if (!p.contains("*") && !p.contains(".")) {
            return p.equals(s);
        }
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        int i = 0, j = 0;
        while (i < sc.length && j < pc.length) {
            if (j < pc.length - 1 && pc[j + 1] == '*') {
                int len = 1;
                if (pc[j] != sc[i] && pc[j] != '.') {  //*代表0
                    j += 2;
                    continue;
                } else if (pc[j] != '.') {
                    while (i + len < sc.length && sc[i + len] == pc[j]) {
                        len++;
                    }
                } else {
                    len = sc.length - i;
                }
                if (j + 2 == pc.length) {  //模式串到达末尾
                    if (i + len == sc.length) {
                        return true;
                    } else {
                        return false;
                    }
                }
                while (len > 0) {  //尝试匹配len个字符
                    if (isMatch(s.substring(i + len, sc.length), p.substring(j + 2, pc.length))) {
                        return true;
                    }
                    len--;
                }
                j += 2;
            } else if (pc[j] == '.' || sc[i] == pc[j]) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        if (i < sc.length) {
            return false;
        }
        while (j < pc.length) {
            if (j < pc.length - 1 && pc[j + 1] == '*') {
                j += 2;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatch().isMatch("mississippi", "mis*is*p*."));
    }

}
