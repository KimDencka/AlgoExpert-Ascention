package dencka.kim.easy.collection;

import java.util.Arrays;

public class TandemBicycle {
    public static void main(String[] args) {
        int[] red = {5, 3, 2, 5, 9};
        int[] blue = {3, 2, 6, 1, 7};

        System.out.println(tandemBicycle(red, blue, true));
    }

    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        int result = 0;
        int i = fastest ? redShirtSpeeds.length - 1 : 0;

        for (int num : redShirtSpeeds) {
            result += Math.max(num, blueShirtSpeeds[i]);
            i += fastest ? -1 : 1;
        }
        return result;
    }
}
