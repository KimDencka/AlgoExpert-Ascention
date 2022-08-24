package dencka.kim.easy.collection;

import java.util.Arrays;
import java.util.HashSet;

public class TwoNumberSum {
    public static void main(String[] args) {
        int[] nums = {3, 5, -4, 8, 11, 1, -1, 6};
        System.out.println(Arrays.toString(twoNumberSum(nums, 10)));
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        HashSet<Integer> visited = new HashSet<>();
        for (int num : array) {
            if (visited.contains(targetSum - num)) {
                return new int[]{targetSum - num, num};
            } else {
                visited.add(num);
            }
        }
        return new int[0];
    }
}
