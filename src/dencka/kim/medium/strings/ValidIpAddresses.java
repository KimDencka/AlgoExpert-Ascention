package dencka.kim.medium.strings;

import java.util.*;

class ValidIpAddresses {
    public static void main(String[] args) {
        System.out.println(validIPAddresses("1921680"));
    }

    public static ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < string.length() - 3; i++) {
            for (int j = i + 1; j < string.length() - 2; j++) {
                for (int k = j + 1; k < string.length() - 1; k++) {
                    String s1 = string.substring(0, i + 1);
                    String s2 = string.substring(i + 1, j + 1);
                    String s3 = string.substring(j + 1, k + 1);
                    String s4 = string.substring(k + 1);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        result.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return result;
    }

    public static boolean isValid(String str) {
        return Integer.parseInt(str) < 256 && (str.length() > 1 && str.charAt(0) != '0' || str.length() == 1);
    }
}
