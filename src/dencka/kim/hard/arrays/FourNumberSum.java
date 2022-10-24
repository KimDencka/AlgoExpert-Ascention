package dencka.kim.hard.arrays;

import java.util.*;

class FourNumberSum {
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        ArrayList<Integer[]> result = new ArrayList<>();
        for (int i = 0; i < array.length - 3; i++) {
            for (int j = array.length - 1; j > i; j--) {
                int l = i + 1;
                int r = j - 1;
                while (l < r) {
                    if (array[i] + array[l] + array[r] + array[j] < targetSum) {
                        l++;
                    } else if (array[i] + array[l] + array[r] + array[j] > targetSum) {
                        r--;
                    } else {
                        result.add(new Integer[]{array[i], array[l++], array[r--], array[j]});
                    }
                }
            }
        }

        return result;
    }
}
