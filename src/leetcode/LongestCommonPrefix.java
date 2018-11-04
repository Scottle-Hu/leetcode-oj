package leetcode;

/**
 * leetcode: https://leetcode.com/problems/longest-common-prefix/
 *
 * @author huqj
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int index = 0;
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            if (s.length() < minLen) {
                minLen = s.length();
            }
        }
        StringBuilder ret = new StringBuilder();
        while (index < minLen) {
            char expect = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(index) != expect) {
                    return ret.toString();
                }
            }
            ret.append(expect);
            index++;
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }

}
