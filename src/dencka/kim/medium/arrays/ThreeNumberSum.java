package dencka.kim.medium.arrays;


import java.util.*;

class ThreeNumberSum {
    public static void main(String[] args) {
        int[] nums = {12, 3, 1, 2, -6, 5, -8, 6};
        System.out.println(threeNumberSum(nums, 0));
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        ArrayList<Integer[]> triplets = new ArrayList<>();
        int curSum;
        for (int i = 0; i < array.length - 2; i++) {
            int l = i + 1;
            int r = array.length - 1;
            while (l < r) {
                curSum = array[i] + array[l] + array[r];
                if (curSum == targetSum) {
                    triplets.add(new Integer[]{array[i], array[l], array[r]});
                    l++;
                    r--;
                } else if (curSum < targetSum) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return triplets;
    }
}
