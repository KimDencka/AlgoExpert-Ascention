package dencka.kim.easy.other;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(firstNonRepeatingCharacter("abcdcaf"));
    }

    public static int firstNonRepeatingCharacter(String string) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : string.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < string.length(); i++)
            if (map.get(string.charAt(i)) == 1)
                return i;

        return -1;
    }
}
