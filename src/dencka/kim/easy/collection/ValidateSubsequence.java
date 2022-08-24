package dencka.kim.easy.collection;

import java.util.*;

public class ValidateSubsequence {
    public static void main(String[] args) {
        System.out.println(isValidSubsequence(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(22, 25, 6)));
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        List<Boolean> res = new LinkedList<>();
        int j = 0;
        for (int num : array) {
            if (j < sequence.size() && num == sequence.get(j)) {
                res.add(true);
                j++;
            }
        }
        return res.size() == sequence.size();
    }
}