package dencka.kim.medium.graphs;

import java.util.Arrays;

class RemoveIslands {

    public static void main(String[] args) {
        int[][] input =
                new int[][]{
                        {1, 0, 0, 0, 0, 0},
                        {0, 1, 0, 1, 1, 1},
                        {0, 0, 1, 0, 1, 0},
                        {1, 1, 0, 0, 1, 0},
                        {1, 0, 1, 1, 0, 0},
                        {1, 0, 0, 0, 0, 1},
                };
        System.out.println(Arrays.deepToString(removeIslands(input)));
    }

    public static int[][] removeIslands(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        boolean[][] seen = new boolean[h][w];
        for (int i = 0; i < w; i++) if (matrix[0][i] == 1) run(0, i, matrix, seen);
        for (int i = 0; i < w; i++) if (matrix[h - 1][i] == 1) run(h - 1, i, matrix, seen);
        for (int i = 0; i < h; i++) if (matrix[i][0] == 1) run(i, 0, matrix, seen);
        for (int i = 0; i < h; i++) if (matrix[i][w - 1] == 1) run(i, w - 1, matrix, seen);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!seen[i][j] && matrix[i][j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    public static void run(int i, int j, int[][] matrix, boolean[][] seen) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || seen[i][j]) return;
        if (matrix[i][j] == 0) return;
        seen[i][j] = true;
        run(i, j + 1, matrix, seen);
        run(i, j - 1, matrix, seen);
        run(i + 1, j, matrix, seen);
        run(i - 1, j, matrix, seen);
    }
}
