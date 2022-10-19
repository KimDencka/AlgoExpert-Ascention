package dencka.kim.medium.strings;

class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstring("abaxyzzyxf"));
    }

    public static String longestPalindromicSubstring(String str) {
        int[] curr = {0, 1};
        int[] odd, even, longest;
        for (int i = 1; i < str.length(); i++) {
            odd = getPalindrome(str, i - 1, i + 1);
            even = getPalindrome(str, i - 1, i);
            longest = (odd[1] - odd[0]) > (even[1] - even[0]) ? odd : even;
            curr = (curr[1] - curr[0]) > (longest[1] - longest[0]) ? curr : longest;
        }
        return str.substring(curr[0], curr[1]);
    }

    public static int[] getPalindrome(String str, int l, int r) {
        while (l >= 0 && r < str.length()) {
            if (str.charAt(l) != str.charAt(r)) break;
            l--;
            r++;
        }
        return new int[]{l + 1, r};
    }
}
