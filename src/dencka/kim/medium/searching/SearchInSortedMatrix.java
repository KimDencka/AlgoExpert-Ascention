package dencka.kim.medium.searching;

import java.util.Arrays;

class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004},
        };
        System.out.println(Arrays.toString(searchInSortedMatrix(matrix, 44))); // [3, 3]
    }

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int r = 0, c = matrix[0].length - 1;
        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] > target) c--;
            else if (matrix[r][c] < target) r++;
            else return new int[]{r, c};
        }
        return new int[]{-1, -1};
    }
}