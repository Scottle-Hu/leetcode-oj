package leetcode;

/**
 * leetcode: https://leetcode.com/problems/string-to-integer-atoi/
 * result: success
 *
 * @author huqj
 */
public class String2IntAtoi {

    public int myAtoi(String str) {
        int ret = 0, preMax = Integer.MAX_VALUE / 10;
        boolean startReadNum = false;  //表示开始读取数字，遇到非数字就返回
        boolean negative = false;
        for (char c : str.toCharArray()) {
            if (startReadNum) {
                if (c >= '0' & c <= '9') {
                    if (ret > preMax) {
                        return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    }
                    ret = ret * 10 + (c - '0');
                    if (ret < 0) {
                        return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    }
                } else {
                    return negative ? -ret : ret;
                }
            } else {
                if (c == '-') {
                    negative = true;
                    startReadNum = true;
                } else if (c >= '0' & c <= '9') {
                    startReadNum = true;
                    ret = c - '0';
                } else if (c == '+') {
                    startReadNum = true;
                } else if (c != ' ') {
                    return 0;
                }
            }
        }
        return negative ? -ret : ret;
    }

    public static void main(String[] args) {
        System.out.println(new String2IntAtoi().myAtoi("  -42wwe"));
    }

}
