package dencka.kim.easy.collection;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        System.out.println(Arrays.toString(bubbleSort(input)));
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int cur = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = cur;
                }
            }
        }
        return array;
    }


}
