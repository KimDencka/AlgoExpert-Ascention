package dencka.kim.hard.dynamic_programming;

import java.util.*;

class MaxSumIncreasingSubsequence {
    public static void main(String[] args) {
        int[] input = {10, 70, 20, 30, 50, 11, 30};
        System.out.println(maxSumIncreasingSubsequence(input));
    }

    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        int[] sequences = new int[array.length];
        Arrays.fill(sequences, Integer.MIN_VALUE);
        int[] sums = array.clone();
        int maxSumIdx = 0;
        for (int i = 1; i < array.length; i++) {
            int cur = array[i];
            for (int j = 0; j < i; j++) {
                int other = array[j];
                if (other < cur && sums[j] + cur >= sums[i]) {
                    sums[i] = sums[j] + cur;
                    sequences[i] = j;
                }
            }
            if (sums[i] >= sums[maxSumIdx]) maxSumIdx = i;
        }
        return buildSequence(array, sequences, maxSumIdx, sums[maxSumIdx]);
    }

    private static List<List<Integer>> buildSequence(
            int[] array,
            int[] sequences,
            int currentIdx,
            int sums
    ) {
        List<List<Integer>> sequence = new ArrayList<>();
        sequence.add(new ArrayList<>());
        sequence.add(new ArrayList<>());
        sequence.get(0).add(sums);
        while (currentIdx != Integer.MIN_VALUE) {
            sequence.get(1).add(0, array[currentIdx]);
            currentIdx = sequences[currentIdx];
        }
        return sequence;
    }
}
