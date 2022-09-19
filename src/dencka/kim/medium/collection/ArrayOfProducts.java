package dencka.kim.medium.collection;

import java.util.Arrays;

class ArrayOfProducts {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayOfProducts(new int[]{5, 1, 4, 2})));
    }

    public static int[] arrayOfProducts(int[] array) {
        int[] left = new int[array.length];
        int[] right = new int[array.length];

        int cur = 1;
        for (int i = 0; i < left.length; i++) {
            left[i] = cur;
            cur *= array[i];

        }
        cur = 1;
        for (int i = left.length - 1; i >= 0; i--) {
            right[i] = cur;
            cur *= array[i];
        }
        for (int i = 0; i < left.length; i++) {
            left[i] *= right[i];
        }
        return left;
    }
}
