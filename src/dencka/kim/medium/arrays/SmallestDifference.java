package dencka.kim.medium.arrays;

import java.util.Arrays;

class SmallestDifference {
    public static void main(String[] args) {
        int[] nums1 = {-1, 5, 10, 20, 28, 3};
        int[] nums2 = {26, 134, 135, 15, 17};

        System.out.println(Arrays.toString(smallestDifference(nums1, nums2)));
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int holder = Integer.MAX_VALUE;
        int[] result = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int first = 0;
        int second = 0;
        while (first < arrayOne.length && second < arrayTwo.length) {
            int diff = Math.abs(arrayOne[first] - arrayTwo[second]);
            if (holder > diff) {
                holder = diff;
                result[0] = arrayOne[first];
                result[1] = arrayTwo[second];
            }
            if (arrayOne[first] < arrayTwo[second])
                first++;
            else
                second++;
        }
        return result;
    }
}
