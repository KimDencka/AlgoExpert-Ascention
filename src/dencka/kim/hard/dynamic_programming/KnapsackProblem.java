package dencka.kim.hard.dynamic_programming;

import java.util.*;

class KnapsackProblem {
    public static void main(String[] args) {
        int[][] input = {{1, 2}, {4, 3}, {5, 6}, {6, 7}};
        System.out.println(knapsackProblem(input, 10));
    }

    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        int[][] knapsackValues = new int[items.length + 1][capacity + 1];
        for (int i = 1; i <= items.length; i++) {
            int curWeight = items[i - 1][1];
            int curValue = items[i - 1][0];
            for (int c = 0; c <= capacity; c++) {
                if (curWeight > c) knapsackValues[i][c] = knapsackValues[i - 1][c];
                else {
                    knapsackValues[i][c] =
                            Math.max(
                                    knapsackValues[i - 1][c],
                                    knapsackValues[i - 1][c - curWeight] + curValue
                            );
                }
            }
        }

        return getKnapsackItems(knapsackValues, items, knapsackValues[items.length][capacity]);
    }

    private static List<List<Integer>> getKnapsackItems(int[][] knapsackValues, int[][] items, int weight) {
        List<List<Integer>> sequence = new ArrayList<>();
        List<Integer> totalWeight = new ArrayList<>();
        totalWeight.add(weight);
        sequence.add(totalWeight);
        sequence.add(new ArrayList<>());

        int i = knapsackValues.length - 1;
        int c = knapsackValues[0].length - 1;
        while (i > 0) {
            if (knapsackValues[i][c] != knapsackValues[i - 1][c]) {
                sequence.get(1).add(0, i - 1);
                c -= items[i - 1][1];
            }
            i--;
            if (c == 0) break;
        }
        return sequence;
    }
}
