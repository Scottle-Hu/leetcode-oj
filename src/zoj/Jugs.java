package zoj;

import java.util.*;

/**
 * ZOJ Problem Set - 1005
 * result:runtime error
 * @author huqj
 */
public class Jugs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            int target = in.nextInt();
            List<String> solve = solve(a, b, target);
            if (solve != null) {
                for (String s : solve) {
                    System.out.println(s);
                }
            }
        }
    }


    //宽度遍历
    static List<String> solve(int a, int b, int target) {
        Queue<Result> queue = new LinkedList<Result>();
        Result start = new Result();
        start.a = 0;
        start.b = 0;
        queue.add(start);
        while (!queue.isEmpty()) {
            Result top = queue.poll();
            int a1 = top.a;
            int b1 = top.b;
            List<String> sol = top.solve;
            if (a1 == target || b1 == target) {
                sol.add("success");
                return sol;
            }
            if (a1 > 0) {
                List<String> sol1 = new ArrayList<>();
                sol1.addAll(sol);
                sol1.add("empty A");
                Result tmp = new Result();
                tmp.a = 0;
                tmp.b = b1;
                tmp.solve = sol1;
                queue.offer(tmp);
            }
            if (b1 > 0) {
                List<String> sol1 = new ArrayList<>();
                sol1.addAll(sol);
                sol1.add("empty B");
                Result tmp = new Result();
                tmp.a = a1;
                tmp.b = 0;
                tmp.solve = sol1;
                queue.offer(tmp);
            }
            if (a1 < a) {
                List<String> sol1 = new ArrayList<>();
                sol1.addAll(sol);
                sol1.add("fill A");
                Result tmp = new Result();
                tmp.a = a;
                tmp.b = b1;
                tmp.solve = sol1;
                queue.offer(tmp);
            }
            if (b1 < b) {
                List<String> sol1 = new ArrayList<>();
                sol1.addAll(sol);
                sol1.add("fill B");
                Result tmp = new Result();
                tmp.a = a1;
                tmp.b = b;
                tmp.solve = sol1;
                queue.offer(tmp);
            }
            if (b1 < b && a1 > 0) {
                List<String> sol1 = new ArrayList<>();
                sol1.addAll(sol);
                sol1.add("pour A B");
                Result tmp = new Result();
                tmp.b = b1 + a1 > b ? b : b1 + a1;
                tmp.a = b1 + a1 > b ? a1 + b1 - b : 0;
                tmp.solve = sol1;
                queue.offer(tmp);
            }
            if (a1 < a && b1 > 0) {
                List<String> sol1 = new ArrayList<>();
                sol1.addAll(sol);
                sol1.add("pour B A");
                Result tmp = new Result();
                tmp.a = b1 + a1 > a ? a : b1 + a1;
                tmp.b = b1 + a1 > a ? a1 + b1 - a : 0;
                tmp.solve = sol1;
                queue.offer(tmp);
            }
        }
        return null;
    }

}

class Result {
    public int a;
    public int b;
    public List<String> solve = new ArrayList<>();
}
