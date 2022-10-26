package dencka.kim.hard.arrays;

import java.util.*;

class LargestRange {
    public static void main(String[] args) {
        int[] input = {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};
        System.out.println(Arrays.toString(largestRange(input)));
    }

    public static int[] largestRange(int[] array) {
        Set<Integer> set = new HashSet<>();
        int[] res = {array[0], array[0]};
        for (int num : array) set.add(num);

        for (int number : array) {
            if (set.contains(number)) {
                int min = number;
                int max = number;
                while (set.contains(max + 1)) max += 1;
                while (set.contains(min - 1)) min -= 1;
                if (max - min > res[1] - res[0]) {
                    res[0] = min;
                    res[1] = max;
                }
            }
        }
        return res;
    }
}
