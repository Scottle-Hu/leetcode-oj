package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode: https://leetcode.com/problems/integer-to-roman/
 *
 * @author huqj
 */
public class Integer2Roman {

    public String intToRoman(int num) {
        List<Integer> numbers = new ArrayList<>();
        int mul = 1;
        while (num > 0) {
            int digit = num - (num / 10) * 10;
            numbers.add(digit * mul);
            mul *= 10;
            num /= 10;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = numbers.size() - 1; i >= 0; i--) {
            int n = numbers.get(i);
            if (n < 10) {
                if (n == 9) {
                    sb.append("IX");
                } else if (n >= 5) {
                    sb.append("V");
                    for (int j = 0; j < n - 5; j++) {
                        sb.append("I");
                    }
                } else if (n == 4) {
                    sb.append("IV");
                } else {
                    for (int j = 0; j < n; j++) {
                        sb.append("I");
                    }
                }
            } else if (n == 10) {
                sb.append("X");
            } else if (n < 50) {
                if (n == 40) {
                    sb.append("XL");
                } else {
                    int m = n / 10;
                    for (int j = 0; j < m; j++) {
                        sb.append("X");
                    }
                }
            } else if (n == 50) {
                sb.append("L");
            } else if (n < 100) {
                if (n == 90) {
                    sb.append("XC");
                } else {
                    sb.append("L");
                    int m = (n - 50) / 10;
                    for (int j = 0; j < m; j++) {
                        sb.append("X");
                    }
                }
            } else if (n == 100) {
                sb.append("C");
            } else if (n < 500) {
                if (n == 400) {
                    sb.append("CD");
                } else {
                    int m = n / 100;
                    for (int j = 0; j < m; j++) {
                        sb.append("C");
                    }
                }
            } else if (n == 500) {
                sb.append("D");
            } else if (n < 1000) {
                if (n == 900) {
                    sb.append("CM");
                } else {
                    sb.append("D");
                    int m = (n - 500) / 100;
                    for (int j = 0; j < m; j++) {
                        sb.append("C");
                    }
                }
            } else {
                int m = n / 1000;
                for (int j = 0; j < m; j++) {
                    sb.append("M");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Integer2Roman().intToRoman(1994));
    }
}
