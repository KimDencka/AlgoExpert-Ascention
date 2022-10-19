package dencka.kim.medium.strings;

import java.util.*;

class ReverseWordsInString {
    public static void main(String[] args) {
        System.out.println(reverseWordsInString("AlgoExpert is the best!"));
    }

    public static String reverseWordsInString(String string) {
        ArrayList<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch == 32) {
                words.add(string.substring(start, i));
                start = i;
            } else if (string.charAt(start) == 32) {
                words.add(" ");
                start = i;
            }
        }
        words.add(string.substring(start));
        Collections.reverse(words);
        return String.join("", words);
    }
}
