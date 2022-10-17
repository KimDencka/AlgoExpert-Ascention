package dencka.kim.easy.searching;

import java.util.Arrays;

class FindThreeLargestNumbers {
    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -7, -17, -27, -18, -541, -8, -7, 7};

        System.out.println(Arrays.toString(findThreeLargestNumbers(nums)));
    }

    public static int[] findThreeLargestNumbers(int[] array) {
        int[] result = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : array) {
            if (num > result[2])
                shiftAndUpdate(result, num, 2);
            else if (num > result[1])
                shiftAndUpdate(result, num, 1);
            else if (num > result[0])
                shiftAndUpdate(result, num, 0);
        }
        return result;
    }

    public static void shiftAndUpdate(int[] arr, int num, int ind) {
        for (int i = 0; i < ind + 1; i++)
            if (i == ind)
                arr[i] = num;
            else
                arr[i] = arr[i + 1];
    }
}
