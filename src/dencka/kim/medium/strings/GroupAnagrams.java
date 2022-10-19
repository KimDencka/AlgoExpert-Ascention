package dencka.kim.medium.strings;

import java.util.*;

class GroupAnagrams {
    public static void main(String[] args) {
        List<String> words =
                new ArrayList<>(
                        Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"));
        System.out.println(groupAnagrams(words));
    }

    public static List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            char[] w = word.toCharArray();
            Arrays.sort(w);
            String str = new String(w);
            if (!map.containsKey(str)) map.put(str, new ArrayList<>(List.of(word)));
            else map.get(str).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
