package zoj;

import java.util.*;

/**
 * ZOJ Problem Set - 1002
 * result； wrong answer
 * @author Administrator
 */
public class FireNet {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        while ((n = in.nextInt()) != 0) {
            int[][] map = new int[n][n];
            List<Pair> pairList = new ArrayList<Pair>();
            for (int i = 0; i < n; i++) {
                String line = in.next();
                for (int j = 0; j < n; j++) {
                    if (line.charAt(j) == 'X') {
                        map[i][j] = 1;
                    } else {
                        map[i][j] = 0;
                        pairList.add(new Pair(i, j));
                    }
                }
            }
            //solve
            int size = pairList.size();
            if (size == 0) {
                System.out.println(0);
                break;
            }
            Set<Integer> exclude = new HashSet<>();
            Set<Integer> repeat = new HashSet<>();
            for (int i = 1; i < size; i++) {
                repeat.add(i);
            }
            Stack<Integer> s = new Stack<>();
            s.push(0);
            disable(0, repeat, exclude, map, pairList);
            int max = 1;
            while (!s.isEmpty()) {
                if (repeat.size() > 0) {
                    int next = findOne(repeat, size);
                    s.push(next);
                    disable(next, repeat, exclude, map, pairList);
                    if (s.size() > max) {
                        max = s.size();
                    }
                } else {
                    while (!s.isEmpty()) {
                        int top = s.pop();
                        reAble(top, exclude, map, repeat, pairList);
                        int next = findNext(top, repeat, size);
                        if (next != -1) {
                            s.push(next);
                            disable(next, repeat, exclude, map, pairList);
                            break;
                        }
                    }
                }
            }
            System.out.println(max);
        }
    }

    //排除相斥点
    private static void disable(int cur, Set<Integer> repeat, Set<Integer> exclude, int[][] map, List<Pair> pairList) {
        repeat.remove(cur);
        Pair pair = pairList.get(cur);
        Iterator<Integer> iterator = repeat.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            Pair tmp = pairList.get(i);
            if (isExcluded(pair, tmp, map)) {
                iterator.remove();
                exclude.add(i);
            }
        }
    }

    //恢复相斥点
    private static void reAble(int cur, Set<Integer> exclude, int[][] map, Set<Integer> repeat, List<Pair> pairList) {
        repeat.add(cur);
        Iterator<Integer> iterator = exclude.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            Pair pair = pairList.get(i);
            boolean flag = true;
            for (int j = 0; j < pairList.size(); j++) {
                if (repeat.contains(j) || exclude.contains(j)) {
                    continue;
                }
                Pair p = pairList.get(j);
                if (isExcluded(pair, p, map)) {
                    flag = false;
                }
            }
            if (flag) {
                iterator.remove();
                repeat.add(i);
            }
        }
    }

    private static boolean isExcluded(Pair p1, Pair p2, int[][] map) {
        if (p1.col != p2.col && p1.row != p2.row) {
            return false;
        }
        if (p1.row == p2.row) {
            int colMin = Math.min(p1.col, p2.col);
            int colMax = Math.max(p1.col, p2.col);
            for (int i = colMin; i < colMax; i++) {
                if (map[p1.row][i] == 1) {
                    return false;
                }
            }
            return true;
        } else {
            int rowMin = Math.min(p1.row, p2.row);
            int rowMax = Math.max(p1.row, p2.row);
            for (int i = rowMin; i < rowMax; i++) {
                if (map[i][p1.col] == 1) {
                    return false;
                }
            }
            return true;
        }
    }

    private static int findOne(Set<Integer> set, int size) {
        return findNext(-1, set, size);
    }

    private static int findNext(int cur, Set<Integer> set, int size) {
        for (int i = cur + 1; i < size; i++) {
            if (set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

}

class Pair {
    public int row;
    public int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Pair && ((Pair) obj).row == this.row && ((Pair) obj).col == this.col;
    }
}
