package dencka.kim.easy.collection;

import java.util.*;

public class ProductSum {
    public static void main(String[] args) {
        List<Object> test = new ArrayList<>(
                Arrays.asList(
                        5,
                        2,
                        new ArrayList<Object>(Arrays.asList(7, -1)),
                        3, new ArrayList<Object>(
                                Arrays.asList(
                                        6,
                                        new ArrayList<Object>(Arrays.asList(-13, 8)),
                                        4
                                ))));

        System.out.println(productSum(test));
    }

    public static int productSum(List<Object> array) {
        return countSum(array, 1);
    }

    public static int countSum(List<Object> arr, int depth) {
        int cnt = 0;
        for (Object elem : arr) {
            if (elem instanceof List) {
                cnt += countSum((List<Object>) elem, depth + 1);
            } else {
                cnt += (int) elem;
            }
        }
        return cnt * depth;
    }

}
