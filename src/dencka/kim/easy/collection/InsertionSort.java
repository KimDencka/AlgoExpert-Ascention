package dencka.kim.easy.collection;

import java.util.Arrays;

class InsertionSort {
    public static void main(String[] args) {
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        System.out.println(Arrays.toString(insertionSort(input)));
    }

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        return array;
    }
}
