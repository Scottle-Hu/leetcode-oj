package zoj;

import java.util.*;

/**
 * ZOJ Problem Set - 1002
 * result:runtime error
 * @author huqj
 */
public class CrashingBallon {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int max = in.nextInt();
            int min = in.nextInt();
            List<Set<Integer>> maxSub = getSub(max);
            List<Set<Integer>> minSub = getSub(min);
            boolean win = false;
            Set<Integer> test = new HashSet<>();
            for (Set<Integer> ms : maxSub) {
                for (Set<Integer> ms2 : minSub) {
                    test.clear();
                    test.addAll(ms);
                    test.addAll(ms2);
                    if (test.size() == ms.size() + ms2.size()) {
                        win = true;
                        break;
                    }
                }
                if (win) {
                    break;
                }
            }
            if (win) {
                System.out.println(max);
            } else {
                System.out.println(min);
            }
        }
    }

    public static List<Set<Integer>> getSub(int max) {
        List<Set<Integer>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        fun(max, set, res);
        return res;
    }

    private static void fun(int n, Set<Integer> set, List<Set<Integer>> list) {
        int n2 = n;
        for (int i : set) {
            n /= i;
        }
        List<Set<Integer>> subs = new ArrayList<>();
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= Math.min(100, sqrt); i++) {
            if (!set.contains(i) && n % i == 0 && n / i != i && n / i <= 100 && !set.contains(n / i)) {
                Set<Integer> tmp = new HashSet<>();
                tmp.add(i);
                tmp.add(n / i);
                subs.add(tmp);
            }
        }
        if (!set.contains(n) && subs.size() == 0) {  //该因子不可拆分,递归结束
            Set<Integer> tSet = new HashSet<>();
            tSet.addAll(set);
            tSet.add(n);
            addByDiff(list, tSet);
        } else {
            for (Set<Integer> s : subs) {
                //把这两个加进去
                Set<Integer> tSet = new HashSet<>();
                tSet.addAll(set);
                tSet.addAll(s);
                addByDiff(list, tSet);

                List<Integer> t = new ArrayList<>();
                t.addAll(s);
                set.add(t.get(0));
                fun(n2, set, list);
                set.remove(t.get(0));  //回溯
                set.add(t.get(1));
                fun(n2, set, list);
                set.remove(t.get(1));
            }
        }

    }

    private static void addByDiff(List<Set<Integer>> list, Set<Integer> tSet) {
        boolean flag = true;
        for (Set<Integer> s : list) {
            if (s.size() != tSet.size()) {
                continue;
            }
            Set<Integer> tmp = new HashSet<>();
            tmp.addAll(s);
            tmp.removeAll(tSet);
            if (tmp.isEmpty()) {
                flag = false;
                break;
            }
        }
        if (flag) {
            list.add(tSet);
        }
    }
}
