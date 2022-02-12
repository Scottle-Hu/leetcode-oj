package leetcode;

/**
 * leetcode: https://leetcode.com/problems/longest-palindromic-substring/
 * result: 遍历方法success，分治方法stack overflow，
 * 2022-01-25： 递归方法 success，但是感觉有点问题，代码有点乱 TODO
 *
 * @author huqj
 */
public class LongestPalindromeSubStr {

    public String longestPalindrome(String s) {
        LenAndBoundary result = longestPalindrome2(s);
        if (result.length > 0) {
            return s.substring(result.left, result.right + 1);
        }
        return "";
    }

    public LenAndBoundary longestPalindrome2(String s) {
        if (s.length() == 1) {
            return new LenAndBoundary(1, 0, 0);
        }
        LenAndBoundary result = longestPalindrome2(s.substring(0, s.length() - 1));
        if (result.right == s.length() - 2) {
            //结束边界在末尾
            if (result.left > 0) {
                if (s.charAt(result.left - 1) == s.charAt(s.length() - 1)) {
                    return new LenAndBoundary(result.length + 2, result.left - 1, result.right + 1);
                } else if (isPalindromic(s, result.left, s.length() - 1)) {
                    return new LenAndBoundary(result.length + 1, result.left, result.right + 1);
                } else {
                    return result;
                }
            } else {
                if (isPalindromic(s, 0, s.length() - 1)) {
                    return new LenAndBoundary(s.length(), 0, s.length() - 1);
                } else {
                    if (isPalindromic(s, result.left + 1, s.length() - 1)) {
                        return new LenAndBoundary(result.length, result.left + 1, result.right + 1);
                    } else {
                        return result;
                    }
                }
            }
        } else {
            char endChar = s.charAt(s.length() - 1);
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.length() - i < result.length) {
                    break;
                }
                if (s.charAt(i) == endChar && isPalindromic(s, i, s.length() - 1)) {
                    if (s.length() - i >= result.length) {
                        return new LenAndBoundary(s.length() - i, i, s.length() - 1);
                    }
                }
            }
            return result;
        }
    }

    public boolean isPalindromic(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    static class LenAndBoundary {
        public int length;
        public int left;
        public int right;

        public LenAndBoundary(int length, int left, int right) {
            this.length = length;
            this.left = left;
            this.right = right;
        }
    }

//    public String longestPalindrome(String s) {
//        if (s.length() <= 1) {
//            return s;
//        }
//        String maxResult = "";
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = s.length() - 1; j > i; j--) {
//                if (s.charAt(i) == s.charAt(j)) {
//                    int i1 = i, j1 = j;
//                    boolean suc = true;
//                    while (i1 < j1) {
//                        if (s.charAt(i1) == s.charAt(j1)) {
//                            i1++;
//                            j1--;
//                        } else {
//                            suc = false;
//                            break;
//                        }
//                    }
//                    if (suc) {
//                        String tmp = s.substring(i, j + 1);
//                        maxResult = tmp.length() > maxResult.length() ? tmp : maxResult;
//                        break;
//                    }
//                }
//            }
//        }
//        return "".equals(maxResult) ? s.charAt(0) + "" : maxResult;
//    }

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
