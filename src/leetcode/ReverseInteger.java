package leetcode;

/**
 * leetcode: https://leetcode.com/problems/reverse-integer/
 * result: success
 *
 * @author huqj
 */
public class ReverseInteger {

    public int reverse(int x) {
        int max = (int) Math.pow(2, 31) - 1, min = -1 * (int) Math.pow(2, 31);
        boolean negative = x < 0;
        if (negative) {
            x = -x;
        }
        long ret = 0;
        while (x > 0) {
            int tail = x - 10 * (x / 10);
            ret = ret * 10 + tail;
            x /= 10;
        }
        if (negative) {
            ret *= -1;
        }
        return ret >= min && ret <= max ? (int) ret : 0;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(1534236469));
    }

}
