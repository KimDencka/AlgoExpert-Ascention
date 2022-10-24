package dencka.kim.hard.arrays;

import java.util.*;
import java.util.zip.CheckedInputStream;

class ZigZagTravers {
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        List<Integer> result = new ArrayList<>();
        int width = array.get(0).size() - 1;
        int height = array.size() - 1;
        boolean goingDown = true;
        int row = 0;
        int col = 0;
        while (!outOfBounds(row, col, height, width)) {
            result.add(array.get(row).get(col));
            if (goingDown) {
                if (col == 0 || row == height) {
                    goingDown = false;
                    if (row == height) {
                        col++;
                    } else {
                        row++;
                    }
                } else {
                    row++;
                    col--;
                }
            } else {
                if (row == 0 || col == width) {
                    goingDown = true;
                    if (col == width) {
                        row++;
                    } else {
                        col++;
                    }
                } else {
                    row--;
                    col++;
                }
            }
        }

        return result;
    }

    public static boolean outOfBounds(int row, int col, int height, int width) {
        return row < 0 || row > height || col < 0 || col > width;
    }
}
