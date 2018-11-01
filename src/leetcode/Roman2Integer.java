package leetcode;

/**
 * leetcode: https://leetcode.com/problems/roman-to-integer/
 *
 * @author huqj
 */
public class Roman2Integer {

    public int romanToInt(String s) {
        int ret = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; ) {
            char c = ch[i];
            if (i < ch.length - 1) {
                if (c == 'I' && ch[i + 1] == 'V') {
                    ret += 4;
                    i += 2;
                    continue;
                } else if (c == 'I' && ch[i + 1] == 'X') {
                    ret += 9;
                    i += 2;
                    continue;
                } else if (c == 'X' && ch[i + 1] == 'L') {
                    ret += 40;
                    i += 2;
                    continue;
                } else if (c == 'X' && ch[i + 1] == 'C') {
                    ret += 90;
                    i += 2;
                    continue;
                } else if (c == 'C' && ch[i + 1] == 'D') {
                    ret += 400;
                    i += 2;
                    continue;
                } else if (c == 'C' && ch[i + 1] == 'M') {
                    ret += 900;
                    i += 2;
                    continue;
                }
            }
            if (c == 'I') {
                ret += 1;
            } else if (c == 'V') {
                ret += 5;
            } else if (c == 'X') {
                ret += 10;
            } else if (c == 'L') {
                ret += 50;
            } else if (c == 'C') {
                ret += 100;
            } else if (c == 'D') {
                ret += 500;
            } else if (c == 'M') {
                ret += 1000;
            }
            i++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Roman2Integer().romanToInt("MCMXCIV"));
    }

}
