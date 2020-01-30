package leetcode;

import java.util.*;

/**
 * leetcode: https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * result: success
 *
 * @author huqj
 */
public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.isEmpty() || words.length == 0) {
            return Collections.emptyList();
        }

        Set<Integer> result = new HashSet<>();

        int wordCount = words.length;
        int wordLen = words[0].length();

        Set<String> wordSet = new HashSet<>(Arrays.asList(words));

        for (String word : wordSet) {
            //找到以每个单词开头的可能子串
            int i = 0;
            while (true) {
                int index = s.indexOf(word, i);
                if (index == -1 || index + wordCount * wordLen > s.length()) {
                    break;
                }
                if (isCombinationOfWords(s.substring(index, index + wordCount * wordLen), new LinkedList<>(Arrays.asList(words)))) {
                    result.add(index);
                }
                i = index + 1;
            }
        }
        return new LinkedList<>(result);
    }

    private boolean isCombinationOfWords(String s, LinkedList<String> words) {
        if (words.size() == 0 || s == null) {
            return false;
        }
        if (words.size() == 1) {
            return s.equals(words.get(0));
        }
        int wordLen = words.get(0).length();
        int index = 0;
        while (index + wordLen <= s.length()) {
            String w = s.substring(index, index + wordLen);
            words.remove(w);
            index = index + wordLen;
        }
        return words.isEmpty();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word", "good", "best"};
        System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(s, words));
        System.out.println("cost " + (System.currentTimeMillis() - start) + " ms");
    }
}
