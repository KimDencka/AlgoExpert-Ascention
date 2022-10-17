package dencka.kim.medium.dynamic_programming;

class LevensteinDistance {
    public static void main(String[] args) {
        System.out.println(levenshteinDistance("abc", "yabd"));
    }

    public static int levenshteinDistance(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        int[][] edits = new int[len2 + 1][len1 + 1];
        for (int i = 0; i < len2 + 1; i++) {
            for (int j = 0; j < len1 + 1; j++) {
                edits[i][j] = j;
            }
            edits[i][0] = i;
        }
        for (int i = 1; i < len2 + 1; i++) {
            for (int j = 1; j < len1 + 1; j++) {
                if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
                    edits[i][j] = edits[i - 1][j - 1];
                } else {
                    edits[i][j] = 1 + Math.min(edits[i - 1][j - 1], Math.min(edits[i - 1][j], edits[i][j - 1]));
                }
            }
        }
        return edits[len2][len1];
    }

//    public static int levenshteinDistance(String str1, String str2) {
//        String small = str1.length() < str2.length() ? str1 : str2;
//        String big = str1.length() >= str2.length() ? str1 : str2;
//        int[] evenEdits = new int[small.length() + 1];
//        int[] oddEdits = new int[small.length() + 1];
//        for (int j = 0; j < small.length() + 1; j++) evenEdits[j] = j;
//
//        int[] currentEdits;
//        int[] previousEdits;
//        for (int i = 1; i < big.length() + 1; i++) {
//            if (i % 2 == 1) {
//                currentEdits = oddEdits;
//                previousEdits = evenEdits;
//            } else {
//                currentEdits = evenEdits;
//                previousEdits = oddEdits;
//            }
//            currentEdits[0] = i;
//            for (int j = 1; j < small.length() + 1; j++) {
//                if (big.charAt(i - 1) == small.charAt(j - 1)) {
//                    currentEdits[j] = previousEdits[j - 1];
//                } else {
//                    currentEdits[j] = 1 + Math.min(previousEdits[j - 1], Math.min(previousEdits[j], currentEdits[j - 1]));
//                }
//            }
//        }
//        return big.length() % 2 == 0 ? evenEdits[small.length()] : oddEdits[small.length()];
//    }
}
