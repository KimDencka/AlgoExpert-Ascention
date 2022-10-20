package dencka.kim.medium.recursion;

import java.util.*;

class PhoneNumberMnemonics {
    public static void main(String[] args) {
        String phoneNumber = "1905";
        System.out.println(phoneNumberMnemonics(phoneNumber));
    }

    public static ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('0', new ArrayList<>(List.of('0')));
        map.put('1', new ArrayList<>(List.of('1')));
        map.put('2', new ArrayList<>(List.of('a', 'b', 'c')));
        map.put('3', new ArrayList<>(List.of('d', 'e', 'f')));
        map.put('4', new ArrayList<>(List.of('g', 'h', 'i')));
        map.put('5', new ArrayList<>(List.of('j', 'k', 'l')));
        map.put('6', new ArrayList<>(List.of('m', 'n', 'o')));
        map.put('7', new ArrayList<>(List.of('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<>(List.of('t', 'u', 'v')));
        map.put('9', new ArrayList<>(List.of('w', 'x', 'y', 'z')));
        ArrayList<String> result = new ArrayList<>();
        run(0, phoneNumber.toCharArray(), result, map);
        return result;
    }

    public static void run(int idx, char[] phone, List<String> letters, Map<Character, List<Character>> map) {
        if (idx == phone.length) {
            letters.add(new String(phone));
            return;
        }
        List<Character> list = map.get(phone[idx]);
        char prevChar = phone[idx];
        for (Character character : list) {
            phone[idx] = character;
            run(idx + 1, phone, letters, map);
        }
        phone[idx] = prevChar;
    }
}
