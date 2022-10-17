package dencka.kim.medium.arrays;

import java.util.*;

class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int[][] input = {{1, 2}, {3, 5}, {4, 7}, {6, 8}, {9, 10}};
        System.out.println(Arrays.deepToString(mergeOverlappingIntervals(input)));
    }

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
