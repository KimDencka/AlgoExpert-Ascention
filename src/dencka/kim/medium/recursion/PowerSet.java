package dencka.kim.medium.recursion;

import java.util.*;

class PowerSet {
    public static void main(String[] args) {
        System.out.println(powerset(new ArrayList<>(List.of(1, 2, 3))));
    }

    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        run(0, array, new ArrayList<>(), result);
        return result;
    }

    public static void run(int idx, List<Integer> array, List<Integer> power, List<List<Integer>> powers) {
        powers.add(new ArrayList<>(power));
        if (power.size() == array.size()) return;
        for (int i = idx; i < array.size(); i++) {
            power.add(array.get(i));
            run(i + 1, array, power, powers);
            power.remove(power.size() - 1);
        }
    }
}
