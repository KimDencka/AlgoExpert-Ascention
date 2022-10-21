package dencka.kim.hard.binary_search_trees;

import java.util.*;

class SameBSTs {
    public static void main(String[] args) {
        List<Integer> arrayOne = new ArrayList<>(Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11));
        List<Integer> arrayTwo = new ArrayList<>(Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81));
        System.out.println(sameBsts(arrayOne, arrayTwo));
    }

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.size() == 0 && arrayTwo.size() == 0) return true;
        if ((arrayOne.size() != arrayTwo.size()) || (!Objects.equals(arrayOne.get(0), arrayTwo.get(0)))) return false;
        if (arrayOne.size() == 1) return Objects.equals(arrayOne.get(0), arrayTwo.get(0));

        List<Integer> left1 = new ArrayList<>();
        List<Integer> right1 = new ArrayList<>();
        List<Integer> left2 = new ArrayList<>();
        List<Integer> right2 = new ArrayList<>();
        for (int i = 1; i < arrayOne.size(); i++) {
            if (arrayOne.get(i) < arrayOne.get(0)) {
                left1.add(arrayOne.get(i));
            } else {
                right1.add(arrayOne.get(i));
            }

            if (arrayTwo.get(i) < arrayTwo.get(0)) {
                left2.add(arrayTwo.get(i));
            } else {
                right2.add(arrayTwo.get(i));
            }
        }
        return sameBsts(left1, left2) && sameBsts(right1, right2);
    }
}
