package dencka.kim.medium.stacks;

import java.util.*;

class SunsetViews {
    public static void main(String[] args) {
        int[] buildings = new int[] {3, 5, 4, 4, 3, 1, 3, 2};
        System.out.println(sunsetViews(buildings, "EAST")); // 1, 3, 6, 7
    }
    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        ArrayList<Integer> result = new ArrayList<>();
        int highest = 0;
        if (direction.equals("EAST")) {
            for (int i = buildings.length - 1; i >= 0; i--) {
                if (buildings[i] > highest) {
                    result.add(0, i);
                    highest = buildings[i];
                }
            }
        } else {
            for (int i = 0; i < buildings.length; i++) {
                if (buildings[i] > highest) {
                    result.add(i);
                    highest = buildings[i];
                }
            }
        }
        return result;
    }
}
