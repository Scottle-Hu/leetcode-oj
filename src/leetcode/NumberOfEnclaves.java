package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/number-of-enclaves/
 */
public class NumberOfEnclaves {

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] gridCanBeReached = new int[m * n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && grid[i][j] == 1) {
                    queue.offer(convertIndex(n, i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (gridCanBeReached[index] == 1) {
                continue;
            }
            gridCanBeReached[index] = 1;
            int i = index / n;
            int j = index % n;
            for (int i2 = i - 1; i2 <= i + 1; i2++) {
                for (int j2 = j - 1; j2 <= j + 1; j2++) {
                    if (Math.abs(i2 - i) + Math.abs(j2 - j) == 1
                            && i2 >= 0 && i2 < m && j2 >= 0 && j2 < n
                            && grid[i2][j2] == 1
                            && gridCanBeReached[convertIndex(n, i2, j2)] == 0) {
                        queue.offer(convertIndex(n, i2, j2));
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && gridCanBeReached[convertIndex(n, i, j)] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private int convertIndex(int n, int i, int j) {
        return i * n + j;
    }

}
