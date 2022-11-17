package dencka.kim.hard.dynamic_programming;

import java.util.Arrays;

class MaximumSumSubmatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5, 3, -1, 5},
                {-7, 3, 7, 4},
                {12, 8, 0, 0},
                {1, -8, -8, 2}
        };
        System.out.println(maximumSumSubmatrix(matrix, 2));

    }

    public static int maximumSumSubmatrix(int[][] matrix, int size) {
        int[][] sums = createSubmatrix(matrix);
        int max = Integer.MIN_VALUE;
        for (int[] arr : sums) System.out.println(Arrays.toString(arr));

        for (int r = size - 1; r < matrix.length; r++) {
            for (int c = size - 1; c < matrix[0].length; c++) {
                int total = sums[r][c];

                boolean onTop = (r - size < 0);
                if (!onTop) total -= sums[r - size][c];
                boolean onLeft = (c - size < 0);
                if (!onLeft) total -= sums[r][c - size];
                boolean onTopOrOnLeft = onTop || onLeft;
                if (!onTopOrOnLeft) total += sums[r - size][c - size];

                max = Math.max(total, max);
            }
        }

        return max;
    }

    private static int[][] createSubmatrix(int[][] matrix) {
        int[][] sums = new int[matrix.length][matrix[0].length];
        sums[0][0] = matrix[0][0];

        for (int i = 1; i < matrix[0].length; i++) sums[0][i] = sums[0][i - 1] + matrix[0][i];
        for (int i = 1; i < matrix.length; i++) sums[i][0] = sums[i - 1][0] + matrix[i][0];

        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[0].length; c++) {
                sums[r][c] = sums[r - 1][c] + sums[r][c - 1] - sums[r - 1][c - 1] + matrix[r][c];
            }
        }
        return sums;
    }
}
