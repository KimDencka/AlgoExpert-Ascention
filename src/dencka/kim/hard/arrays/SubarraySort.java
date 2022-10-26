package dencka.kim.hard.arrays;

import java.util.Arrays;

class SubarraySort {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        System.out.println(Arrays.toString(subarraySort(input)));
    }

    public static int[] subarraySort(int[] array) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (isOutOfOrder(i, array[i], array)) {
                max = Math.max(max, array[i]);
                min = Math.min(min, array[i]);
            }
        }
        System.out.println(min + " " + max);
        if (min == Integer.MAX_VALUE) return new int[]{-1, -1};

        int leftIdx = 0;
        while (array[leftIdx] < min) leftIdx++;
        int rightIdx = array.length - 1;
        while (array[rightIdx] > max) rightIdx--;

        return new int[]{leftIdx, rightIdx};
    }

    public static boolean isOutOfOrder(int i, int num, int[] array) {
        if (i == 0) {
            return num > array[i + 1];
        } else if (i == array.length - 1) {
            return num < array[i - 1];
        } else {
            return num > array[i + 1] || num < array[i - 1];
        }
    }
}
