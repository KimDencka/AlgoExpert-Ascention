package dencka.kim.medium.graphs;

import java.util.*;

class MinimumPassesOfMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, -1, -3, 2, 0}, {1, -2, -5, -1, -3}, {3, 0, 0, -4, -1}};
        System.out.println(minimumPassesOfMatrix(matrix));
    }

    static boolean hasNegative;
    public static int minimumPassesOfMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int res = 0;
        while (!queue.isEmpty()) {
            Queue<int[]> newQueue = queue;
            hasNegative = false;
            queue = new LinkedList<>();
            while (!newQueue.isEmpty()) {
                int[] cur = newQueue.poll();
                int i = cur[0];
                int j = cur[1];
                dfs(i + 1, j, matrix, queue);
                dfs(i - 1, j, matrix, queue);
                dfs(i, j + 1, matrix, queue);
                dfs(i, j - 1, matrix, queue);
            }
            if (hasNegative) res++;
        }
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (ints[j] < 0) return -1;
            }
        }
        return res;
    }

    public static void dfs(int i, int j, int[][] matrix, Queue<int[]> queue) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] >= 0) return;
        matrix[i][j] *= -1;
        queue.add(new int[]{i, j});
        hasNegative = true;
    }
}
