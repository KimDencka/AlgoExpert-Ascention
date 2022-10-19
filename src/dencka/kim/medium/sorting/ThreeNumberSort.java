package dencka.kim.medium.sorting;

import java.util.*;

class ThreeNumberSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 0, 0, -1, -1, 0, 1, 1,};
        int[] order = new int[]{0, 1, -1};
        System.out.println(Arrays.toString(threeNumberSort(array, order)));
    }

    public static int[] threeNumberSort(int[] array, int[] order) {
        int i = 0;
        for (int n = 0; n < 2; n++) {
            for (int j = i; j < array.length; j++) {
                if (array[j] != order[n]) continue;
                int temp = array[i];
                array[i++] = array[j];
                array[j] = temp;
            }
        }
        return array;
    }
}
