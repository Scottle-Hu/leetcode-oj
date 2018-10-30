package zoj;

import java.util.*;

/**
 * ZOJ Problem Set - 1004
 * result:runtime error
 * @author huqj
 */
public class AnagramsByStack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String source = in.next();
            String target = in.next();
            List<String> result = new ArrayList<>();
            solve(new Stack<Character>(), source, target, "", result);
            Collections.sort(result, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            System.out.println("[");
            for (String s : result) {
                System.out.println(s);
            }
            System.out.println("]");
        }
    }

    static void solve(Stack<Character> stack, String sub, String target, String result, List<String> list) {
        if (target.length() == 0) {
            list.add(result);
        } else {
            String result2 = result;
            char c = target.charAt(0);
            if (!stack.isEmpty() && stack.peek() == c) {
                result2 += "o ";
                stack.pop();
                solve(stack, sub, target.substring(1), result2, list);
                stack.push(c);
            }
            for (int i = 0; i < sub.length(); i++) {
                if (sub.charAt(i) == c) {
                    result2 = result;
                    for (int j = 0; j <= i; j++) {
                        stack.push(sub.charAt(j));
                        result2 += "i ";
                    }
                    stack.pop();
                    result2 += "o ";
                    solve(stack, sub.substring(i + 1), target.substring(1), result2, list);
                    for (int j = 0; j < i; j++) {
                        stack.pop();
                    }
                }
            }
        }
    }
}
