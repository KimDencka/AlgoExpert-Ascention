package dencka.kim.medium.graphs;

import java.util.*;

class RiverSizes {
    public static void main(String[] args) {
        int[][] input = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0},
        };
        System.out.println(riverSizes(input));
    }

    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) continue;
                res.add(dfs(0, i, j, matrix));
            }
        }
        return res;
    }

    public static int dfs(int size, int i, int j, int[][] matrix) {
        if (i < 0 | j < 0 || i == matrix.length || j == matrix[0].length) return 0;
        if (matrix[i][j] == 0) return 0;
        matrix[i][j] = 0;
        int top = dfs(size, i - 1, j, matrix);
        int right = dfs(size, i, j + 1, matrix);
        int bottom = dfs(size, i + 1, j, matrix);
        int left = dfs(size, i, j - 1, matrix);
        size = top + right + bottom + left + 1;
        return size;
    }
}
