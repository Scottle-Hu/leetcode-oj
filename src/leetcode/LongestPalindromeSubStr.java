package leetcode;

/**
 * leetcode: https://leetcode.com/problems/longest-palindromic-substring/
 * result: 遍历方法success，分治方法stack overflow
 *
 * @author huqj
 */
public class LongestPalindromeSubStr {

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String maxResult = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    int i1 = i, j1 = j;
                    boolean suc = true;
                    while (i1 < j1) {
                        if (s.charAt(i1) == s.charAt(j1)) {
                            i1++;
                            j1--;
                        } else {
                            suc = false;
                            break;
                        }
                    }
                    if (suc) {
                        String tmp = s.substring(i, j + 1);
                        maxResult = tmp.length() > maxResult.length() ? tmp : maxResult;
                        break;
                    }
                }
            }
        }
        return "".equals(maxResult) ? s.charAt(0) + "" : maxResult;
    }

//    public String longestPalindrome(String s) {
//        if (s.length() == 1) {
//            return s;
//        }
//        //分治
//        int mid = s.length() / 2;
//        String leftResult = longestPalindrome(s.substring(0, mid));
//        String rightResult = longestPalindrome(s.substring(mid, s.length()));
//        String maxResult = leftResult.length() >= rightResult.length() ? leftResult : rightResult;
//        //找跨越两边的最大回文序列
//        //对称轴在左边
//        int index = mid;
//        char c = s.charAt(index);
//        for (int i = 0; i < index; i++) {
//            if (s.charAt(i) == c) {
//                boolean suc = true;
//                for (int j = i; j < index; j++) {
//                    if (s.charAt(j) == s.charAt(index)) {
//                        j++;
//                        index--;
//                    } else {
//                        suc = false;
//                        break;
//                    }
//                }
//                if (suc) {
//                    index = mid;
//                    while (index < s.length() && i >= 0) {
//                        if (s.charAt(index) == s.charAt(i)) {
//                            index++;
//                            i--;
//                        } else {
//                            break;
//                        }
//                    }
//                    String tmpMax = s.substring(i + 1, index);
//                    if (tmpMax.length() > maxResult.length()) {
//                        maxResult = tmpMax;
//                    }
//                    break;
//                }
//            }
//            index = mid;
//        }
//        //对称轴在右边
//        index = mid - 1;
//        c = s.charAt(index);
//        for (int i = s.length() - 1; i > index; i--) {
//            if (s.charAt(i) == c) {
//                boolean suc = true;
//                for (int j = i; j > index; j--) {
//                    if (s.charAt(index) == s.charAt(j)) {
//                        j--;
//                        index++;
//                    } else {
//                        suc = false;
//                        break;
//                    }
//                }
//                if (suc) {
//                    index = mid - 1;
//                    while (index >= 0 && i < s.length()) {
//                        if (s.charAt(index) == s.charAt(i)) {
//                            i++;
//                            index--;
//                        } else {
//                            break;
//                        }
//                    }
//                    String tmpMax = s.substring(index + 1, i);
//                    if (tmpMax.length() > maxResult.length()) {
//                        maxResult = tmpMax;
//                    }
//                    break;
//                }
//            }
//            mid = index - 1;
//        }
//        return maxResult;
//    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromeSubStr().longestPalindrome("abacab"));
    }

}
