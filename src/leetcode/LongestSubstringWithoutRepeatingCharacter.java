package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * result: success
 *
 * @author huqj
 */
public class LongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, alreadyMax = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                alreadyMax = Math.max(max, alreadyMax);
                max = 1;
                set.clear();
                set.add(c);
                //find backward
                int t = i - 1;
                while (t >= 0) {
                    char tc = s.charAt(t);
                    if (set.contains(tc)) {
                        break;
                    } else {
                        set.add(tc);
                        max++;
                        t--;
                    }
                }
            } else {
                max++;
                set.add(c);
            }
        }
        return Math.max(max, alreadyMax);
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacter().lengthOfLongestSubstring("abcabcbb"));
    }
}
