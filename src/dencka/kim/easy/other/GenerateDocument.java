package dencka.kim.easy.other;

import java.util.HashMap;

public class GenerateDocument {
    public static void main(String[] args) {
        System.out.println(generateDocument("abcabc", "aabbcc"));
    }

    public static boolean generateDocument(String characters, String document) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < characters.length(); i++) {
            char ch = characters.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < document.length(); i++) {
            char ch = document.charAt(i);
            if (!map.containsKey(ch)) return false;
            else if (map.get(ch) == 0) return false;
            else map.put(ch, map.get(ch) - 1);
        }
        return true;
    }
}
