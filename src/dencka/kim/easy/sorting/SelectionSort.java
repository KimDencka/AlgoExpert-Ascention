package dencka.kim.easy.sorting;

import java.util.Arrays;

class SelectionSort {
    public static void main(String[] args) {
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        System.out.println(Arrays.toString(selectionSort(input)));
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minInd = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[minInd] > array[j])
                    minInd = j;

            int cur = array[minInd];
            array[minInd] = array[i];
            array[i] = cur;
        }

        return array;
    }
}
