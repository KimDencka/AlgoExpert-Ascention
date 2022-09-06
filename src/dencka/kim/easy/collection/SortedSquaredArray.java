package dencka.kim.easy.collection;

import java.util.Arrays;

class SortedSquaredArray {
    public static void main(String[] args) {
        int[] nums = {-5, -4, -3, -2, -1};
        System.out.println(Arrays.toString(sortedSquaredArray(nums)));
    }

    public static int[] sortedSquaredArray(int[] array) {
        int cnt = array.length - 1;
        int firstInx = 0;
        int lastIdx = array.length - 1;
        int[] res = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (Math.abs(array[firstInx]) > Math.abs(array[lastIdx])) {
                res[cnt - i] = array[firstInx] * array[firstInx];
                firstInx++;
            } else {
                res[cnt - i] = array[lastIdx] * array[lastIdx];
                lastIdx--;
            }
        }
        return res;

//        int[] res = new int[array.length];
//        for (int i = 0; i < array.length; i++) {
//            res[i] = array[i] * array[i];
//        }
//        Arrays.sort(res);
//        return res;
    }
}
