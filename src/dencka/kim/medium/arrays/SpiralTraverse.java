package dencka.kim.medium.arrays;

import java.util.*;

class SpiralTraverse {
    public static void main(String[] args) {
        int[][] input = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };

        int[][] input2 = {{1, 2, 3},
                {12, 13, 4},
                {11, 14, 5},
                {10, 15, 6},
                {9, 8, 7}
        };
        printAll(Objects.requireNonNull(spiralTraverse(input)));
        System.out.println();
        printAll(Objects.requireNonNull(spiralTraverse(input2)));
    }

    public static List<Integer> spiralTraverse(int[][] array) {
        int n = array.length * array[0].length;
        List<Integer> ans = new ArrayList<>();
        int startRow = 0;
        int endRow = array.length - 1;
        int startCol = 0;
        int endCol = array[0].length - 1;
        while (startCol <= endCol && startRow <= endRow) {
            for (int col = startCol; col <= endCol && ans.size() != n; col++)
                ans.add(array[startRow][col]);

            for (int row = startRow + 1; row <= endRow && ans.size() != n; row++)
                ans.add(array[row][endCol]);

            for (int col = endCol - 1; col >= startCol && ans.size() != n; col--)
                ans.add(array[endRow][col]);

            for (int row = endRow - 1; row > startRow && ans.size() != n; row--)
                ans.add(array[row][startCol]);


            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return ans;
    }

    public static void printAll(List<Integer> list) {
        list.forEach(num -> System.out.print(num + " "));
    }
}