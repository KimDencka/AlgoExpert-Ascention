package dencka.kim.easy.greedy_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class ClassPhotos {
    public static void main(String[] args) {
        ArrayList<Integer> red = new ArrayList<>(Arrays.asList(2, 4, 5, 6, 9));
        ArrayList<Integer> blue = new ArrayList<>(Arrays.asList(1, 3, 4, 5, 8));

        System.out.println(classPhotos(red, blue));
    }

    public static boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        int cnt = 0;
        for (int i = 0; i < redShirtHeights.size(); i++) {
            if (redShirtHeights.get(i) > blueShirtHeights.get(i)) cnt++;
            else if (redShirtHeights.get(i) < blueShirtHeights.get(i)) cnt--;
            else return false;
        }
        return Math.abs(cnt) == redShirtHeights.size();
    }
}
