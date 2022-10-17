package dencka.kim.medium.arrays;

import java.util.*;

class FirstDuplicateValue {
    public static void main(String[] args) {
        System.out.println(firstDuplicateValue(new int[]{2, 1, 5, 2, 3, 3, 4}));
    }

    public static int firstDuplicateValue(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array)
            if (set.contains(num)) return num;
            else set.add(num);
        return -1;
    }
}
