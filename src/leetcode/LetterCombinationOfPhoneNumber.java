package leetcode;

import java.util.*;

/**
 * leetcode: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * result: success
 *
 * @author huqj
 */
public class LetterCombinationOfPhoneNumber {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        Map<Character, List<Character>> num2Letter = new HashMap<>();
        num2Letter.put('2', new ArrayList<Character>() {{
            add('a');
            add('b');
            add('c');
        }});
        num2Letter.put('3', new ArrayList<Character>() {{
            add('d');
            add('e');
            add('f');
        }});
        num2Letter.put('4', new ArrayList<Character>() {{
            add('g');
            add('h');
            add('i');
        }});
        num2Letter.put('5', new ArrayList<Character>() {{
            add('j');
            add('k');
            add('l');
        }});
        num2Letter.put('6', new ArrayList<Character>() {{
            add('m');
            add('n');
            add('o');
        }});
        num2Letter.put('7', new ArrayList<Character>() {{
            add('p');
            add('q');
            add('r');
            add('s');
        }});
        num2Letter.put('8', new ArrayList<Character>() {{
            add('t');
            add('u');
            add('v');
        }});
        num2Letter.put('9', new ArrayList<Character>() {{
            add('w');
            add('x');
            add('y');
            add('z');
        }});
        List<String> ret = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        char[] chars = digits.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            stack.push(0);
        }
        int index = chars.length - 1;
        ret.add(buildFromStack(stack, num2Letter, chars));
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            List<Character> letters = num2Letter.get(chars[index]);
            if (pop < letters.size() - 1) {
                stack.push(pop + 1);
                while (index < chars.length - 1) {
                    index++;
                    stack.push(0);
                }
                ret.add(buildFromStack(stack, num2Letter, chars));
            } else {
                index--;
            }
        }
        return ret;
    }

    private String buildFromStack(Stack<Integer> s, Map<Character, List<Character>> map, char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.size(); i++) {
            sb.append(map.get(chars[i]).get(s.get(i)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinationOfPhoneNumber().letterCombinations("23"));
    }

}
