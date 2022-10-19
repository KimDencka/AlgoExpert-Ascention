package dencka.kim.medium.strings;

import java.util.*;

class MinimumCharactersForWords {
    public static void main(String[] args) {
        String[] words = new String[]{"this", "that", "did", "deed", "them!", "a"};
        System.out.println(minimumCharactersForWords(words));
    }

    public static char[] minimumCharactersForWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            Map<Character, Integer> curr = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                curr.put(ch, curr.getOrDefault(ch, 0) + 1);
                if (!map.containsKey(ch)) {
                    map.put(ch, map.getOrDefault(ch, 0) + 1);
                    res.append(ch);
                } else if (curr.get(ch) > map.get(ch)) {
                    map.replace(ch, curr.get(ch));
                    res.append(ch);
                }
            }
        }
        return res.toString().toCharArray();
    }
}
