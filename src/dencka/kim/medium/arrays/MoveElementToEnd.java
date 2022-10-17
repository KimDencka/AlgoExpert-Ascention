package dencka.kim.medium.arrays;

import java.util.*;

class MoveElementToEnd {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));

        printAll(moveElementToEnd(array, 2));
    }

    //output: 41322222
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int end = array.size() - 1;
        for (int i = 0; i < end; i++) {
            while (array.get(end) == toMove && i < end)
                end--;
            int cur = array.get(i);
            if (cur == toMove) {
                array.set(i, array.get(end));
                array.set(end, cur);
            }
        }
        return array;
    }


    //output: 13422222
//    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
//        int cnt = 0;
//        for (int i = 0; i < array.size(); i++) {
//            if (array.get(i) != toMove)
//                array.set(cnt++, array.get(i));
//        }
//        while (cnt < array.size()) {
//            array.set(cnt++, toMove);
//        }
//        return array;
//    }

    public static void printAll(List<Integer> array) {
        array.forEach(System.out::print);
    }
}
