package leetcode;

/**
 * leetcode: https://leetcode.com/problems/palindrome-number/
 * result: success
 *
 * @author huqj
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        char[] str = String.valueOf(x).toCharArray();
        for (int i = 0; i < str.length / 2; i++) {
            if (str[i] != str[str.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
