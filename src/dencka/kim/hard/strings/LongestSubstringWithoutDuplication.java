package dencka.kim.hard.strings;

import java.util.*;

class LongestSubstringWithoutDuplication {
    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutDuplication("clementisacap"));
    }

    public static String longestSubstringWithoutDuplication(String str) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int[] longest = {0, 1};
        int startIdx = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (lastSeen.containsKey(ch)) {
                startIdx = Math.max(startIdx, lastSeen.get(ch) + 1);
            }
            if (longest[1] - longest[0] < i + 1 - startIdx) {
                longest = new int[]{startIdx, i + 1};
            }
            lastSeen.put(ch, i);
        }
        return str.substring(longest[0], longest[1]);
    }
}
