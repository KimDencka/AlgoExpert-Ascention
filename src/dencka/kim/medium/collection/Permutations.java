package dencka.kim.medium.collection;

import java.util.*;

class Permutations {
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        if (array.isEmpty()) return null;
        List<List<Integer>> result = new ArrayList<>();
        generate(new ArrayList<>(), new HashSet<>(), array, result);
        return result;
    }

    public static void main(String[] args) {
        getPermutations(List.of(1, 2, 3, 4));
    }

    public static void generate(List<Integer> cur, Set<Integer> seen, List<Integer> given, List<List<Integer>> result) {
        if (cur.size() == given.size()) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int num : given) {
            if (seen.contains(num)) continue;
            cur.add(num);
            seen.add(num);
            generate(cur, seen, given, result);
            seen.remove(num);
            cur.remove(cur.size() - 1);
        }
    }
}
